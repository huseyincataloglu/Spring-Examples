package com.huseyin.ToDoListApp.auth.dto;

import com.huseyin.ToDoListApp.user.model.entity.Users;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
public class RegisterUserRequest {


    @NotBlank
    @Size(min = 5,message = "Username length should be at least 5")
    private String username;

    @NotBlank
    @Digits(integer = 5,message = "Password should be numeric value of 5 digits",fraction = 0)
    private String password;


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



}