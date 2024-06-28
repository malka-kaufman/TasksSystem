package com.example.server.service;

import com.example.server.beans.AgentQueue;
import com.example.server.beans.TaskQueue;
import com.example.server.data.model.AgentEntity;
import com.example.server.data.repository.AgentRepository;
import com.example.server.data.repository.TaskRepository;
import com.example.server.enums.Status;
import com.example.server.service.queue.AvailableAgentQueue;
import com.example.server.service.queue.OpenTaskQueue;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UpdateAgentAvailability {
    private final AgentRepository agentRepository;
    private final AvailableAgentQueue availableAgentQueue;
    private final TaskRepository taskRepository;
    private final OpenTaskQueue openTaskQueue;
    private final AddAgentToQueue addAgentToQueue;

    public void updateAgentAvailability(Long id, boolean available) {
        var agentEntity = agentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Agent does not exist"));

        var updateAgentEntity = agentEntity.toBuilder().available(available).build();

        var agentQueue = AgentQueue.builder().id(updateAgentEntity.getId()).tasksNum(updateAgentEntity.getTasksNum()).build();

        if (available) {
            addAgentToQueue.add(agentQueue);

            agentRepository.save(agentEntity);
        } else {

            if (availableAgentQueue.agentInQueue(agentQueue)) {
                availableAgentQueue.removeAgent(agentQueue);
            }

            taskRepository.findByAgent_IdAndStatusEqualsIgnoreCase(id, Status.ASSIGNED.name())
                    .ifPresent(taskEntity -> {
                        taskEntity.toBuilder().status(Status.CREATED.name()).agent(null);
                        taskRepository.save(taskEntity);

                        openTaskQueue.addTask(TaskQueue.builder().id(taskEntity.getId()).build());

                        agentRepository.save(updateAgentEntity.toBuilder().tasksNum(0).build());
                    });
        }
    }
}
