package com.huseyin.ToDoListApp.user.model.dto;


import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ChangePasswordRequest {

    @NotBlank
    @Digits(integer = 6,message = "Password must be 6 digits",fraction = 0)
    private String password;

}
