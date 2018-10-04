package com.service.impl;

import com.annotation.TrackTime;
import com.entity.Customer;
import com.entity.Task;
import com.repository.CustomerRepository;
import com.repository.TaskRepository;
import com.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository,
                           CustomerRepository customerRepository) {
        this.taskRepository = taskRepository;
        this.customerRepository = customerRepository;
    }

    @TrackTime
    @Override
    public List<Task> getAllTasks() {
        Customer customer = new Customer();
        customer.setFirstName("first name");
        customer.setLastName("second name");
        customerRepository.save(customer);
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findOne(id);
    }
}
