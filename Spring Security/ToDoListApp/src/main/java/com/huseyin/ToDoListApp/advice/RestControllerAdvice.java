package com.huseyin.ToDoListApp.advice;

import com.huseyin.ToDoListApp.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {


    @ExceptionHandler(TasksNotFoundByUserIdException.class)
    public ResponseEntity<?> tasksDontExistByUserId(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(List.of());
    }

    @ExceptionHandler(TaskNotFoundByIdException.class)
    public ResponseEntity<?> tasksDontExistById(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(List.of());
    }
    @ExceptionHandler(UsernameIsInUseException.class)
    public ResponseEntity<?> usernameIsInUse(UsernameIsInUseException ex){
        return ResponseEntity
                .badRequest().body(ex.getMessage());
    }
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<?> taskNotFound(TaskNotFoundException ex){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> usernameNotFound(UsernameNotFoundException ex){
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ex.getMessage());
    }

    @ExceptionHandler(WrongTaskStatusException.class)
    public ResponseEntity<?> wrongTaskStatus(WrongTaskStatusException ex){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }





}
