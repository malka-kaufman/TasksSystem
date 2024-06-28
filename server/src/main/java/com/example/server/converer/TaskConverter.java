package com.example.server.converer;

import com.example.server.enums.Status;
import com.example.server.beans.Task;
import com.example.server.data.model.TaskEntity;

public class TaskConverter {

    public static Task toBean(TaskEntity dto) {
        return Task.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .createdDate(dto.getCreatedDate())
                .status(Status.valueOf(dto.getStatus()))
                .build();
    }

    public static TaskEntity toDto(Task bean) {
        return TaskEntity.builder()
                .id(bean.getId())
                .description(bean.getDescription())
                .createdDate(bean.getCreatedDate())
                .status(bean.getStatus().name())
                .build();
    }
}
