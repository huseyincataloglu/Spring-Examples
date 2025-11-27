package com.huseyin.Api.users.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("USERS")
public class Users {
    @Id
    private int id;

    @NotBlank
    @Size(min = 5,max = 20,message = "Username must have at least 5 most 20 charachters")
    @Column("USERNAME")
    private String username;

    @NotBlank
    @Digits(integer = 5,fraction = 0,message = "Password must be 5 digits number")
    @Column("PASSWORD")
    private String password;

    @Column("CREATED_AT")
    private LocalDateTime createdAt;

    @Column("TODOCOUNT")
    private int todocount;

    @Column("ROLE")
    private Role role;

    @Column("EMAIL")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
