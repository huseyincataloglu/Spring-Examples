package com.huseyin.ToDoListApp.tasks.model.entity;

import com.huseyin.ToDoListApp.tasks.model.enumeration.TaskStatus;
import com.huseyin.ToDoListApp.user.model.entity.Users;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Tasks {

    @Id
    @GeneratedValue
    private Long id;


    private String title;

    private String content;

    private TaskStatus status = TaskStatus.ONPROCESS;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "userid",nullable = false)
    private Users user;


}
