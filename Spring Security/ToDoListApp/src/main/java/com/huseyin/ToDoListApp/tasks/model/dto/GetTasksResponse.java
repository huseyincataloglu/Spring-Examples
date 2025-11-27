package com.huseyin.ToDoListApp.tasks.model.dto;



import com.huseyin.ToDoListApp.tasks.model.entity.Tasks;
import com.huseyin.ToDoListApp.tasks.model.enumeration.TaskStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetTasksResponse {

    private Long id;

    private String title;

    private String content;

    private TaskStatus status;

    private LocalDateTime createdAt;

    private String username;


    public GetTasksResponse(Tasks task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.content = task.getContent();
        this.status = task.getStatus();
        this.username = task.getUser().getUsername();
        this.createdAt = task.getCreatedAt();
    }


}
