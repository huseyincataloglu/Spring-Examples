package com.huseyin.ToDoListApp.exception;

public class UsernameIsInUseException extends RuntimeException {
    public UsernameIsInUseException(String message) {
        super(message);
    }
}
