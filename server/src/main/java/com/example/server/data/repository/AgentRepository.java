package com.example.server.data.repository;

import com.example.server.data.model.AgentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<AgentEntity, Long> {
}
