package com.example.server.beans;

import com.example.server.enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

@Getter
@Builder
@Validated
public class Task {
    private Long id;
    @NonNull
    private String description;
    private long createdDate;
    private Status status;
}
