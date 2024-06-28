package com.example.server.service.queue;

import com.example.server.beans.AgentQueue;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.PriorityQueue;

@Service
public class AvailableAgentQueue {
    Comparator<AgentQueue> comparator = new Comparator<AgentQueue>() {
        @Override
        public int compare(AgentQueue a1, AgentQueue a2) {
            return Integer.compare(a1.getTasksNum(), a2.getTasksNum());
        }
    };

    PriorityQueue<AgentQueue> availableAgentQueue = new PriorityQueue<>(comparator);

    public void addAgent(AgentQueue agent) {
        availableAgentQueue.add(agent);
    }

    public void removeAgent(AgentQueue agent) {
        availableAgentQueue.remove(agent);
    }

    public boolean agentInQueue(AgentQueue agent) {
        return availableAgentQueue.contains(agent);
    }

    public boolean isEmpty() {
        return availableAgentQueue.isEmpty();
    }

    public AgentQueue peek() {
        return availableAgentQueue.peek();
    }
}
