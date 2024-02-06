package com.example.demo.application.dto;

public class UpdateTaskStateDTO {
    String id;
    String state;

    public UpdateTaskStateDTO(String id, String state) {
        this.id = id;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public String getState() {
        return state;
    }
}
