package com.mappers;

import com.dto.TaskDto;
import com.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION)
public interface TaskMapper {

    List<TaskDto> toTaskListDto(List<Task> tasks);

    TaskDto toTaskDto(Task tasks);
}