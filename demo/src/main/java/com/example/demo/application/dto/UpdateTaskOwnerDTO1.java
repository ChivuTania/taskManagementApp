package com.example.demo.application.dto;

public class UpdateTaskOwnerDTO1 {
    String id;
    String owner;

    public UpdateTaskOwnerDTO1(String id, String owner) {
        this.id = id;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }
}
