package com.example.demo.application.dto;

public class UpdateSprintDTO1 {
    String id;
    String taskId;
    String operation;

    public UpdateSprintDTO1(String id, String taskId, String operation) {
        this.id = id;
        this.taskId = taskId;
        this.operation = operation;
    }

    public String getId() {
        return id;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getOperation() {
        return operation;
    }
}
