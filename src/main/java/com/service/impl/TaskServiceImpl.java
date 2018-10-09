package com.service.impl;

import com.annotation.TrackTime;
import com.entity.Customer;
import com.entity.Task;
import com.repository.CustomerRepository;
import com.repository.TaskRepository;
import com.service.TaskService;
import com.service.WriteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final CustomerRepository customerRepository;
    private final WriteService writeService;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository,
                           CustomerRepository customerRepository,
                           WriteService writeService) {
        this.taskRepository = taskRepository;
        this.customerRepository = customerRepository;
        this.writeService = writeService;
    }

    @TrackTime
    @Override
    public List<Task> getAllTasks() {
        Customer customer = new Customer();
        customer.setFirstName("first name");
        customer.setLastName("second name");
        customerRepository.save(customer);
//        writeService.writeToFile();
//        writeService.readFromFile();
//        writeService.writeToResource("shakespeare.txt");
//        writeService.readFromResource("shakespeare.txt");
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findOne(id);
    }
}
