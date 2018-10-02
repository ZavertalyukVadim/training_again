package com.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;

    private String username;

    private String email;

    private String password;

    private List<TaskDtoId> tasks;
}
