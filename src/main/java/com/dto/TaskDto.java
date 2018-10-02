package com.dto;

import lombok.Data;

@Data
public class TaskDto {
    private Long id;
    private String description;
    private UserDto user;
}
