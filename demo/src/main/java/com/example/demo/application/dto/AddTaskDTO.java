package com.example.demo.application.dto;

import com.example.demo.domain.Sprint;

public class AddTaskDTO {
    String name;
    String description;
    String owner;
    String deadline;
    String state;
    String sprintName;

    public AddTaskDTO(String name, String description, String owner, String deadline) {
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.deadline = deadline;
        this.state = "TO DO";
        this.sprintName = "";
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getOwner() {
        return owner;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getState() {
        return state;
    }

    public String getSprint() {
        return sprintName;
    }
}
