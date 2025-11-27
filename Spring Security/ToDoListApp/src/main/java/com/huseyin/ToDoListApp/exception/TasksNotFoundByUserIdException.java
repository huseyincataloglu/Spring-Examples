package com.huseyin.ToDoListApp.exception;

public class TasksNotFoundByUserIdException extends RuntimeException {
    public TasksNotFoundByUserIdException() {
        super("You dont have any task.");
    }
}
