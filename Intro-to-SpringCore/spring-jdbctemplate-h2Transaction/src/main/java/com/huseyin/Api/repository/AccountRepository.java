package com.huseyin.Api.repository;

import com.huseyin.Api.model.Account;
import com.huseyin.Api.model.AccountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.AbstractCollection;
import java.util.List;

@Repository
public class AccountRepository {

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public AccountRepository(JdbcTemplate jdbcTemplate){  // Spring boot will automatically create datasource bean which is hikaricp object
        this.jdbcTemplate = jdbcTemplate; // And jdbctempalte object will be initialized and injected here by that data source bean by default
    }


    public Account getAccountById(int id){
        String query = "SELECT * FROM account WHERE id = ?";

        return jdbcTemplate.queryForObject(query,new AccountRowMapper(),id);
    }

    public List<Account> getAllAcounts(){
        String query = "SELECT * FROM account";

        return jdbcTemplate.query(query,new AccountRowMapper());
    }


    public void changeAmount(int id, BigDecimal amount){
        String sql = "UPDATE account SET amount = ?  WHERE id = ?";
        jdbcTemplate.update(sql,amount,id);
    }






}
