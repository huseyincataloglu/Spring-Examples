package com.huseyin.Api.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    //These are for spring boot's default behaviour for datasource creation

    @Value("${spring.datasource.url}")
    private  String url;

    @Value("${spring.datasource.username}")
    private String datasourceUsername;
    @Value("${spring.datasource.password}")
    private String datasourcePassword;


    // This creation will read schema.sql as spring boot will do by default
    @Bean
    @Primary
    public DataSource dataSourcePrimary(){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(url);
        hikariDataSource.setUsername(datasourceUsername);
        hikariDataSource.setPassword(datasourcePassword);
        return hikariDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate3(DataSource dataSource){ // spring boot knows that he need to pass primary datasource bean
        return new JdbcTemplate(dataSource);
    }



    //But these cannot access schema.sql file
    // So if we create datasource manually , we have to bind them a schema.sql file to be able to create database
    @Bean("custom1Db")
    @ConfigurationProperties(prefix = "custom.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean("custom2Db")
    @ConfigurationProperties(prefix = "custom2.datasource")
    public DataSource dataSource2(){
        return DataSourceBuilder.create().build();
    }

    @Bean("custom1DbJdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier(value = "custom1Db") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean("custom2DbJdbcTemplate")
    public JdbcTemplate jdbcTemplate2(@Qualifier(value = "custom2Db") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


}
