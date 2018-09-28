package com.service;

import com.entity.Customer;
import com.entity.Task;
import com.repository.CustomerRepository;
import com.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final CustomerRepository customerRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository,
                       CustomerRepository customerRepository) {
        this.taskRepository = taskRepository;
        this.customerRepository = customerRepository;
    }

    public List<Task> getAllTasks() {
        Customer customer = new Customer();
        customer.setFirstName("first name");
        customer.setLastName("second name");
        customerRepository.save(customer);
        List<Customer> all = customerRepository.findAll();
        System.out.println("ALL = "+all);
        return taskRepository.findAll();
    }
}
