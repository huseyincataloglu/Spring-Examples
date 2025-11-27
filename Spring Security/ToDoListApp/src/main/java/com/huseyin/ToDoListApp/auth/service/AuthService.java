package com.huseyin.ToDoListApp.auth.service;

import com.huseyin.ToDoListApp.auth.dto.RegisterUserRequest;
import com.huseyin.ToDoListApp.exception.UsernameIsInUseException;
import com.huseyin.ToDoListApp.mapper.Mapper;
import com.huseyin.ToDoListApp.user.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    private final UsersService usersService;


    @Autowired
    public AuthService(UsersService usersService){
        this.usersService = usersService;
    }

    @Transactional
    public String registerUser(RegisterUserRequest registerUserRequest){
        if(usersService.existsByUsername(registerUserRequest.getUsername())){
            throw new UsernameIsInUseException("Please type a username which is not used.");
        }
        usersService.createUsers(Mapper.maptoUsers(registerUserRequest));
        return "User is registered successfully";
    }



}
