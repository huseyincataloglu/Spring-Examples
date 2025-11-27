package com.huseyin.ToDoListApp.exception;


public class TaskNotFoundByIdException extends RuntimeException {
    public TaskNotFoundByIdException(Long id) {
        super("Task with id: %d does not exist".formatted(id));
    }
}
