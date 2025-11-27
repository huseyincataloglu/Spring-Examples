package com.huseyin.ToDoListApp.user.controller;

import com.huseyin.ToDoListApp.user.model.dto.ChangePasswordRequest;
import com.huseyin.ToDoListApp.user.model.dto.GetUserInfoResponse;
import com.huseyin.ToDoListApp.user.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/me")
public class UserController {

    private final UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public ResponseEntity<GetUserInfoResponse> getProfile(Authentication authentication){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(usersService.getUserInfo(authentication.getName()));

    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProfile(Authentication authentication){
        usersService.deleteUser(authentication.getName());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("User is removed!");

    }
    @PatchMapping("/password")
    public ResponseEntity<String> changePassword(Authentication authentication, @RequestBody ChangePasswordRequest changePasswordRequest){
        usersService.changePassword(authentication.getName(),changePasswordRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Password is patched!");

    }





}
