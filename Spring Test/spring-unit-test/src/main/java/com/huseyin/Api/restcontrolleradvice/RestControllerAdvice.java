package com.huseyin.Api.restcontrolleradvice;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Map;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {


    @ExceptionHandler(com.huseyin.Api.restcontrolleradvice.AccountNotFoundException.class)
    public ResponseEntity<?> returnAccountNotFound(HttpServletRequest request, AccountNotFoundException ex){
        return getResponseEntity(request, ex,HttpStatus.NOT_FOUND);

    }

    private static ResponseEntity<Map<String, String>> getResponseEntity(
            HttpServletRequest request,
            Throwable ex,
            HttpStatus status) {
        return ResponseEntity.status(status)
                .body(Map.of("Ex message", ex.getMessage(),
                        "Ex name", ex.toString(),
                        "Ex source", request.getRequestURI(),
                        "Status",status.toString()));
    }

    @ExceptionHandler(NotEnoughAmountException.class)
    public ResponseEntity<?> handleNotEnoughMoney(HttpServletRequest request,NotEnoughAmountException ex){
        return getResponseEntity(
                request,
                ex,
                HttpStatus.BAD_REQUEST
        );


    }





}
