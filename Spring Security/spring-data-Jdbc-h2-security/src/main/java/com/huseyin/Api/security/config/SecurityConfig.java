package com.huseyin.Api.security.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class SecurityConfig {


    //When spring security loads , it generates a default user object with default username and password
    //But to be able to compare the password and username we need service
    // authenticaiton manaager is triggered by http request
    // and authentication provider delegated by manager
    // authentication provider uses UserDetailsService's loadUserByUsername method tu authenticate the user
    // So automatically InMemoryUserDetailsManager implementation of UserDetailsService is placed as a bean with Userdetail concrete user pbject
    // and used by authentiaciton manager
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User
                .withUsername("user")
                .password("1234")
                .roles("user")
                .build();
        return new InMemoryUserDetailsManager(user);
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
