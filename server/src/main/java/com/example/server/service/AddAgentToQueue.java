package com.example.server.service;

import com.example.server.beans.AgentQueue;
import com.example.server.service.queue.AvailableAgentQueue;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AddAgentToQueue {
    private final AvailableAgentQueue availableAgentQueue;
    private final AssignTaskToAgent assignTaskToAgent;

    public void add(AgentQueue agentQueue) {
        availableAgentQueue.addAgent(agentQueue);
        assignTaskToAgent.assignTaskToAgent();
    }
}
