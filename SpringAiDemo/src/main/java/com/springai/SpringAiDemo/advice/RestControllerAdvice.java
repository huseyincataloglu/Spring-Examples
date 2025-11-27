package com.springai.SpringAiDemo.advice;

import com.springai.SpringAiDemo.exceptions.NotEnoughMoneyException;
import com.springai.SpringAiDemo.model.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {

    // Special exception handling
    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler(){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("not enough money exception");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }


    // General exception handling
    // Spring runs this method in situation of occurring all types of exceptions
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDetails> exceptionHandler(RuntimeException e){ // Spring passed the exception as parameter from the controller method where it is thrown
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(e.getMessage());
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }


}
