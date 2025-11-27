package com.huseyin.ToDoListApp.tasks.model.dto;



import com.huseyin.ToDoListApp.tasks.model.entity.Tasks;
import com.huseyin.ToDoListApp.user.model.entity.Users;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateTaskRequest  {

    @NotBlank
    @Size(min = 5,message = "Title length must be at least 5")
    private String title;


    @NotBlank
    @Size(min = 1,message = "Content at least must contain one charachter")
    private String content;


}
