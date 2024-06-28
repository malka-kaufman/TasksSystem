package com.example.server.service.queue;

import com.example.server.beans.TaskQueue;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.PriorityQueue;

@Service
public class OpenTaskQueue {
    Comparator<TaskQueue> ageComparator = new Comparator<TaskQueue>() {
        @Override
        public int compare(TaskQueue t1, TaskQueue t2) {
            return Long.compare(t1.getId(), t2.getId());
        }
    };

    PriorityQueue<TaskQueue> taskQueue = new PriorityQueue<>(ageComparator);

    public void addTask(TaskQueue task) {
        taskQueue.add(task);
    }

    public void removeTask(TaskQueue task) {
        taskQueue.remove(task);
    }

    public boolean taskInQueue(TaskQueue task) {
        return taskQueue.contains(task);
    }

    public boolean isEmpty() {
        return taskQueue.isEmpty();
    }

    public TaskQueue peek() {
        return taskQueue.peek();
    }
}
