package com.example.server.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class AgentEntity {
    @Id
    private Long id;
    private String name;
    private String password;
    private boolean manager;
    private int tasksNum;
    private boolean available;
}
