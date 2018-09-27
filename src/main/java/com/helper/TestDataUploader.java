package com.helper;

import com.entity.Role;
import com.entity.Task;
import com.entity.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TestDataUploader {
    private final UserRepository userRepository;

    @Autowired
    public TestDataUploader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void addTestData() {
        User user = new User();
        user.setEmail("user@gmail.com");
        user.setPassword("password");
        user.setUsername("username");
        Role role = new Role();
        role.setName("GOD");
        user.setRole(role);
        Task task = new Task();
        task.setDescription("description");
        task.setUser(user);
        user.addTask(task);
        userRepository.save(user);
    }
}
