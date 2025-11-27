package com.huseyin.ToDoListApp.mapper;

import com.huseyin.ToDoListApp.auth.dto.RegisterUserRequest;
import com.huseyin.ToDoListApp.tasks.model.dto.CreateTaskReponse;
import com.huseyin.ToDoListApp.tasks.model.dto.CreateTaskRequest;
import com.huseyin.ToDoListApp.tasks.model.dto.GetTasksResponse;
import com.huseyin.ToDoListApp.tasks.model.entity.Tasks;
import com.huseyin.ToDoListApp.user.model.dto.ChangePasswordRequest;
import com.huseyin.ToDoListApp.user.model.dto.GetUserInfoResponse;
import com.huseyin.ToDoListApp.user.model.entity.Users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;

public class Mapper {
    private static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static  Users maptoUsers (RegisterUserRequest request){
        Users user = new Users();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return user;

    }

    public static Tasks maptoTasks(CreateTaskRequest request,Users user){
        Tasks tasks = new Tasks();
        tasks.setTitle(request.getTitle());
        tasks.setContent(request.getContent());
        tasks.setUser(user);
        return tasks;
    }


    public static GetTasksResponse mapGetTaskstoResponse(Tasks tasks){
        return new GetTasksResponse(tasks);
    }
    public static CreateTaskReponse mapCreateTasksToResponse (Tasks tasks){
        return new CreateTaskReponse(tasks);
    }

    public static GetUserInfoResponse mapUserToGetUserInfo(Users user){
        return new GetUserInfoResponse(
                user.getId(),
                user.getUsername(),
                user.getTaskCount(),
                user.getCreatedAt()
        );
    }

    public static Users mapChangePasswordRequest(ChangePasswordRequest changePasswordRequest,Users users){
        users.setPassword(passwordEncoder.encode(changePasswordRequest.getPassword()));
        return users;
    }






}
