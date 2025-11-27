package com.huseyin.ToDoListApp.tasks.model.dto;


import com.huseyin.ToDoListApp.tasks.model.enumeration.TaskStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateTaskRequest {

    @NotNull
    private Long id;

    @NotNull
    private TaskStatus taskStatus;


}
