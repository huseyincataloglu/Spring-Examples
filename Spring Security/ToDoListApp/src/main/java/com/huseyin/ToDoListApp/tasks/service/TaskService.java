package com.huseyin.ToDoListApp.tasks.service;


import com.huseyin.ToDoListApp.exception.TaskNotFoundByIdException;
import com.huseyin.ToDoListApp.exception.TaskNotFoundException;
import com.huseyin.ToDoListApp.exception.TasksNotFoundByUserIdException;
import com.huseyin.ToDoListApp.mapper.Mapper;
import com.huseyin.ToDoListApp.tasks.model.dto.CreateTaskReponse;
import com.huseyin.ToDoListApp.tasks.model.dto.CreateTaskRequest;
import com.huseyin.ToDoListApp.tasks.model.dto.GetTasksResponse;
import com.huseyin.ToDoListApp.tasks.model.dto.UpdateTaskRequest;
import com.huseyin.ToDoListApp.tasks.model.entity.Tasks;
import com.huseyin.ToDoListApp.tasks.model.enumeration.TaskStatus;
import com.huseyin.ToDoListApp.tasks.repository.TaskRepository;
import com.huseyin.ToDoListApp.user.model.dto.GetUserInfoResponse;
import com.huseyin.ToDoListApp.user.model.entity.Users;
import com.huseyin.ToDoListApp.user.service.UsersService;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UsersService usersService;

    public TaskService(TaskRepository taskRepository,UsersService usersService){
        this.taskRepository = taskRepository;
        this.usersService = usersService;
    }


    public List<GetTasksResponse> getTasksByUserId(String username,@Nullable TaskStatus status){
        Users user = usersService.findByUsername(username);

        List<Tasks> tasksList= (status == null)
                ? StreamSupport.stream(taskRepository.findByUserId(user.getId()).spliterator(),false).toList()
                : StreamSupport.stream(taskRepository.findByUserIdAndStatus(user.getId(), status).spliterator(),false).toList();


        return tasksList.stream().map(Mapper::mapGetTaskstoResponse).toList();
    }


    public GetTasksResponse getTasksByUserIdAndId(String username,Long id,@Nullable TaskStatus taskStatus){
        Users user = usersService.findByUsername(username);
        Tasks tasks = (taskStatus == null)
                ? taskRepository.findByUserIdAndId(user.getId(),id).orElseThrow(() -> new TaskNotFoundByIdException(id))
                : taskRepository.findByUserIdAndIdAndStatus(user.getId(),id,taskStatus).orElseThrow(TaskNotFoundException::new);
        return Mapper.mapGetTaskstoResponse(tasks);

    }

    @Transactional
    public CreateTaskReponse createTask(String username, CreateTaskRequest createTaskRequest){
        Users user = usersService.findByUsername(username);
        Tasks tasks = Mapper.maptoTasks(createTaskRequest,user);
        return Mapper.mapCreateTasksToResponse(taskRepository.save(tasks));
    }

    @Transactional
    public String changeTask(String username, UpdateTaskRequest updateTaskRequest){
        Users user = usersService.findByUsername(username);
        int affectedRoW = taskRepository.updateStatusById(user.getId(),updateTaskRequest.getId(),updateTaskRequest.getTaskStatus());
        if(affectedRoW == 0){
            throw new TaskNotFoundException();
        }
        return "%d row affected".formatted(affectedRoW);
    }

    @Transactional
    public String deleteAllTasksByUserId(String username){
        Users user = usersService.findByUsername(username);
        int affectedRow =taskRepository.deleteAllByUserId(user.getId());
        if(affectedRow == 0){
            throw new TaskNotFoundException();
        }
        return "%d row affected".formatted(affectedRow);
    }

    @Transactional
    public String deleteTaskByUserIdAndId(String username,Long id){
        Users user = usersService.findByUsername(username);
        Tasks task = taskRepository.findByUserIdAndId(user.getId(),id)
                .orElseThrow(() -> new TaskNotFoundByIdException(id));// user doesnt passsed somneone else's task id

        int affectedRow = taskRepository.deleteByUserIdAndId(user.getId(),id);
        return "%d row is affected".formatted(affectedRow);
    }





}
