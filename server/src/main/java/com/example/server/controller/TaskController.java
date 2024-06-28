package com.example.server.controller;

import com.example.server.beans.Task;
import com.example.server.converer.TaskConverter;
import com.example.server.data.repository.TaskRepository;
import com.example.server.enums.Status;
import com.example.server.service.CreateTask;
import com.example.server.service.UpdateAgentAvailability;
import com.example.server.service.UpdateTaskStatus;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/task")
public class TaskController {
    private TaskRepository taskRepository;
    private CreateTask createTask;
    private final UpdateTaskStatus updateTaskStatus;

    @GetMapping
    public List<Task> getTasksListByAgentId(@RequestParam Long agentId) {
        return taskRepository.findAllByAgent_Id(agentId).stream()
                .map(TaskConverter::toBean)
                .toList();
    }

    @PostMapping
    public void createTask(Task task) {
        createTask.createTask(task);
    }

    @PutMapping("update-status/{id}")
    public void updateTaskStatus(@PathVariable Long id, @RequestParam long agentId, @RequestParam String status) {
        updateTaskStatus.updateTaskStatus(agentId, id, status);
    }
}
