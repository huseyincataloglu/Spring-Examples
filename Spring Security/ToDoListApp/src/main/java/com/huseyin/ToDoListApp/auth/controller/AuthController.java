package com.huseyin.ToDoListApp.auth.controller;

import com.huseyin.ToDoListApp.auth.dto.RegisterUserRequest;
import com.huseyin.ToDoListApp.auth.service.AuthService;
import com.huseyin.ToDoListApp.exception.UsernameIsInUseException;
import com.huseyin.ToDoListApp.mapper.Mapper;
import com.huseyin.ToDoListApp.user.model.entity.Users;
import com.huseyin.ToDoListApp.user.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterUserRequest registerRequest){
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(authService.registerUser(registerRequest));

    }


}
