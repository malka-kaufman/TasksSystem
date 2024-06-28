package com.example.server.controller;

import com.example.server.beans.Agent;
import com.example.server.converer.AgentConverter;
import com.example.server.data.repository.AgentRepository;
import com.example.server.service.CreateAgent;
import com.example.server.service.UpdateAgentAvailability;
import com.example.server.service.UpdateTaskStatus;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/agent")
public class AgentController {

    private final AgentRepository agentRepository;
    private final CreateAgent createAgent;
    private final UpdateAgentAvailability updateAgentAvailability;

    @GetMapping
    public List<Agent> getAgentsList() {
        return agentRepository.findAll().stream()
                .map(AgentConverter::toBean)
                .toList();
    }

    @PostMapping
    public void createAgent(@RequestBody Agent agent) {
        createAgent.createAgent(agent);
    }

    @DeleteMapping("/{id}")
    public void deleteAgent(@PathVariable Long id) {
        agentRepository.deleteById(id);
    }


    @PutMapping("/{id}")
    public void updateAgentAvailability(@PathVariable Long id, @RequestParam boolean available) {
        updateAgentAvailability.updateAgentAvailability(id, available);
    }
}
