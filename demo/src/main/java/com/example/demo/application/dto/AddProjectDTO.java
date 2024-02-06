package com.example.demo.application.dto;

import com.example.demo.domain.Sprint;

import java.util.ArrayList;
import java.util.List;

public class AddProjectDTO {
    String name;
    String description;
    List<Sprint> sprint;
    List<String> members;

    public AddProjectDTO(String name, String description) {
        this.name = name;
        this.description = description;
        this.sprint = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Sprint> getSprint() {
        return sprint;
    }

    public List<String> getMembers() {
        return members;
    }
}
