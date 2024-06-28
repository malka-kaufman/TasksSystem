package com.example.server.data.repository;

import com.example.server.data.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    List<TaskEntity> findAllByAgent_Id(long agentId);
    Optional<TaskEntity> findByAgent_IdAndStatusEqualsIgnoreCase(long agentId, String status);
}
