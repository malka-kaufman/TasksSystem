package com.example.server.service;

import com.example.server.data.model.TaskEntity;
import com.example.server.data.repository.AgentRepository;
import com.example.server.data.repository.TaskRepository;
import com.example.server.enums.Status;
import com.example.server.service.queue.AvailableAgentQueue;
import com.example.server.service.queue.OpenTaskQueue;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AssignTaskToAgent {
    private final AvailableAgentQueue availableAgentQueue;
    private final OpenTaskQueue openTaskQueue;
    private final TaskRepository taskRepository;
    private final TaskWebSocketHandler taskWebSocketHandler;
    private final AgentRepository agentRepository;

    public void assignTaskToAgent() {
        if (!openTaskQueue.isEmpty()) {
            if (!availableAgentQueue.isEmpty()) {
                var task = openTaskQueue.peek();
                var agent = availableAgentQueue.peek();

                taskRepository.findById(task.getId()).ifPresent(taskEntity -> {
                    agentRepository.findById(agent.getId()).ifPresent(agentEntity -> {
                        TaskEntity updateTask = taskEntity.toBuilder().status(Status.ASSIGNED.name()).agent(agentEntity).build();

                        taskRepository.save(updateTask);

                        taskWebSocketHandler.sendEventToClient(agent.getId());

                        availableAgentQueue.removeAgent(agent);

                        openTaskQueue.removeTask(task);
                    });
                });
            }
        }
    }
}
