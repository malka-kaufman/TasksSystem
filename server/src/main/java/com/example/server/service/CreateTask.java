package com.example.server.service;

import com.example.server.beans.Task;
import com.example.server.beans.TaskQueue;
import com.example.server.converer.TaskConverter;
import com.example.server.data.repository.TaskRepository;
import com.example.server.service.queue.OpenTaskQueue;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreateTask {
    private final TaskRepository taskRepository;
    private final OpenTaskQueue openTaskQueue;
    private final AssignTaskToAgent assignTaskToAgent;

    public void createTask(Task task) {
        var newTask = taskRepository.save(TaskConverter.toDto(task));

        var taskQueue = TaskQueue.builder().id(newTask.getId()).build();

        openTaskQueue.addTask(taskQueue);

        assignTaskToAgent.assignTaskToAgent();
    }
}
