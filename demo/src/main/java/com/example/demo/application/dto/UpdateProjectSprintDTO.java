package com.example.demo.application.dto;

import com.example.demo.domain.Sprint;

public class UpdateProjectSprintDTO {
    String id;
    String sprintId;
    String operation;

    public UpdateProjectSprintDTO(String id, String sprintId, String operation) {
        this.id = id;
        this.sprintId = sprintId;
        this.operation = operation;
    }

    public String getId() {
        return id;
    }

    public String getSprintId() {
        return sprintId;
    }

    public String getOperation() {
        return operation;
    }
}
