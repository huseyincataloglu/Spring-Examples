package com.huseyin.ToDoListApp.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException() {
        super("Task is not found!");
    }
}
