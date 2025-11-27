package com.huseyin.ToDoListApp.tasks.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huseyin.ToDoListApp.tasks.model.entity.Tasks;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.time.LocalDateTime;

@Data
public class CreateTaskReponse {

    private Long id;
    private String title;
    private String content;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime createdAt;

    public CreateTaskReponse(Tasks tasks){
        this.id = tasks.getId();
        this.title = tasks.getTitle();
        this.content = tasks.getContent();
        this.createdAt = tasks.getCreatedAt();
    }


}
