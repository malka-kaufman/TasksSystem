package com.example.server.converer;

import com.example.server.beans.Agent;
import com.example.server.data.model.AgentEntity;

public class AgentConverter {
    public static Agent toBean(AgentEntity dto) {
        return Agent.builder()
                .name(dto.getPassword())
                .password(dto.getPassword())
                .manager(dto.isManager())
                .tasksNum(dto.getTasksNum())
                .available(dto.isAvailable())
                .build();
    }

    public static AgentEntity toDto(Agent bean) {
        return AgentEntity.builder()
                .name(bean.getPassword())
                .password(bean.getPassword())
                .tasksNum(bean.getTasksNum())
                .available(bean.isAvailable())
                .manager(bean.isManager())
                .build();
    }
}
