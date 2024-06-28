package com.example.server.service;

import com.example.server.beans.AgentQueue;
import com.example.server.data.model.AgentEntity;
import com.example.server.data.repository.AgentRepository;
import com.example.server.data.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UpdateTaskStatus {
    private final TaskRepository taskRepository;
    private final AgentRepository agentRepository;
    private final AddAgentToQueue addAgentToQueue;

    public void updateTaskStatus(Long agentId, Long taskId, String status) {
        taskRepository.findById(taskId).ifPresent(taskEntity -> {
            taskRepository.save(taskEntity.toBuilder().status(status).build());

            agentRepository.findById(agentId).ifPresent(agentEntity -> {
                addAgentToQueue.add(AgentQueue.builder().id(agentEntity.getId()).build());
            });
        });
    }

}
