package com.example.demo.application.dto;

import com.example.demo.domain.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AddSprintDTO {
    String name;
    String description;
    List<Task> tasks;
    String ProjectName;

    public AddSprintDTO(String name, String description) {
        this.name = name;
        this.description = description;
        this.tasks = new ArrayList<>();
        this.ProjectName = "";
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public String getProjectName() {
        return ProjectName;
    }
}
