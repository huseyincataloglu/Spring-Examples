package com.huseyin.ToDoListApp.tasks.controller;


import com.huseyin.ToDoListApp.auth.shared.AuthenticatedUserProvider;
import com.huseyin.ToDoListApp.mapper.Mapper;
import com.huseyin.ToDoListApp.tasks.model.dto.CreateTaskReponse;
import com.huseyin.ToDoListApp.tasks.model.dto.CreateTaskRequest;
import com.huseyin.ToDoListApp.tasks.model.dto.GetTasksResponse;
import com.huseyin.ToDoListApp.tasks.model.dto.UpdateTaskRequest;
import com.huseyin.ToDoListApp.tasks.model.entity.Tasks;
import com.huseyin.ToDoListApp.tasks.model.enumeration.TaskStatus;
import com.huseyin.ToDoListApp.tasks.service.TaskService;
import com.huseyin.ToDoListApp.user.model.entity.Users;
import com.huseyin.ToDoListApp.user.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;
    private final UsersService usersService;
    private final AuthenticatedUserProvider authenticatedUserProvider;


    public TaskController(TaskService taskService, UsersService usersService, AuthenticatedUserProvider authenticatedUserProvider){
        this.taskService = taskService;
        this.usersService = usersService;
        this.authenticatedUserProvider = authenticatedUserProvider;
    }


    @GetMapping
    public ResponseEntity<?> getTasks(Authentication authentication,@RequestParam(name = "status",required = false) TaskStatus status){
        String username = authentication.getName();
        List<GetTasksResponse> getTasksResponseList = taskService.getTasksByUserId(username,status);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(getTasksResponseList);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getTasks(
            Authentication authentication,
            @PathVariable(name = "id") Long id,
            @RequestParam(name = "status",required = false) TaskStatus taskStatus
    ){
        String username = authentication.getName();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(taskService.getTasksByUserIdAndId(username,id,taskStatus));

    }


    @PostMapping
    public ResponseEntity<?> createTasks(@RequestBody CreateTaskRequest createTasksRequest, Authentication authentication){
        String username = authentication.getName();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(taskService.createTask(username,createTasksRequest));
    }

    @PatchMapping
    public ResponseEntity<?> changeStatus(Authentication authentication, @RequestBody @Valid UpdateTaskRequest updateTaskRequest){
        String response = taskService.changeTask(authentication.getName(),updateTaskRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Patch is succeeded. %s".formatted(response));
    }


    @DeleteMapping
    public ResponseEntity<?> deleteTasks(Authentication authentication){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Deletion is succeeded. " + taskService.deleteAllTasksByUserId(authentication.getName()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(Authentication authentication,@PathVariable(name = "id") Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Deletion is succeeded. " + taskService.deleteTaskByUserIdAndId(authentication.getName(),id));
    }






}
