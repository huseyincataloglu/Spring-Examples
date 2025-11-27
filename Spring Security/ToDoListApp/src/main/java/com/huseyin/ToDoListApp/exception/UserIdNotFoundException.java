package com.huseyin.ToDoListApp.exception;

public class UserIdNotFoundException extends RuntimeException {
    public UserIdNotFoundException(Long user_id) {
        super("Userid: %d is not found".formatted(user_id));
    }
}
