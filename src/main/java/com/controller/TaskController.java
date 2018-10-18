package com.controller;

import com.dto.TaskDto;
import com.mappers.TaskMapper;
import com.service.TaskService;
import com.service.impl.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/api/task")
@RestController
public class TaskController {
    private final TaskService taskService;
    private final AsyncService asyncService;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskController(TaskService taskService,
                          AsyncService asyncService,
                          TaskMapper taskMapper) {
        this.taskService = taskService;
        this.asyncService = asyncService;
        this.taskMapper = taskMapper;
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks() throws InterruptedException {
//        asyncService.printInConsole();
        return new ResponseEntity<>(taskMapper.toTaskListDto(taskService.getAllTasks()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id){
        return new ResponseEntity<>(taskMapper.toTaskDto(taskService.getTaskById(id)), HttpStatus.OK);
    }
}
