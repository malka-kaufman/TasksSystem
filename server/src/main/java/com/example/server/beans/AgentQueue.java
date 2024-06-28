package com.example.server.beans;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AgentQueue {
    private long id;
    private int tasksNum;
}
