package com.huseyin.ToDoListApp.exception;

import com.huseyin.ToDoListApp.tasks.model.enumeration.TaskStatus;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WrongTaskStatusException extends RuntimeException {
    public WrongTaskStatusException(String status){
        super("Wrong task status : %s Task statuses are : %s ".formatted(status,
                Arrays.stream(TaskStatus.values())
                        .map(TaskStatus::getStatus)
                        .collect(Collectors.joining(", "))));
    }
}
