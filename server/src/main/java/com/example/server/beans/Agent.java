package com.example.server.beans;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Agent {
    private Long id;
    private String name;
    private String password;
    private boolean manager;
    private int tasksNum;
    private boolean available;
}
