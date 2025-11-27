package com.huseyin.ToDoListApp.tasks.model.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.huseyin.ToDoListApp.exception.WrongTaskStatusException;
import com.huseyin.ToDoListApp.tasks.model.entity.Tasks;

import java.util.Arrays;

public enum TaskStatus {
    ONPROCESS("onprocess"),
    DONE("done"),
    CANCELED("canceled");

    private String status;

    TaskStatus(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }



    @JsonCreator
    public static TaskStatus fromString(String value) {
        return Arrays.stream(TaskStatus.values())
                .filter(item -> item.status.equals(value))
                .findFirst()
                .orElseThrow(() -> new WrongTaskStatusException(value));
    }

}
