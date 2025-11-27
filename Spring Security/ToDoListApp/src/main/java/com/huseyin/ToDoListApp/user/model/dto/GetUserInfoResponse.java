package com.huseyin.ToDoListApp.user.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huseyin.ToDoListApp.tasks.model.entity.Tasks;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class GetUserInfoResponse {
    private Long id;
    private String username;

    private int taskCount;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;
}

