package com.example.server.service;

import com.example.server.beans.Agent;
import com.example.server.beans.AgentQueue;
import com.example.server.converer.AgentConverter;
import com.example.server.data.repository.AgentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreateAgent {
    private final AgentRepository agentRepository;
    private final AddAgentToQueue addAgentToQueue;

    public void createAgent(Agent agent) {
        var newAgent = agentRepository.save(AgentConverter.toDto(agent));

        addAgentToQueue.add(AgentQueue.builder().id(newAgent.getId()).tasksNum(0).build());
    }
}
