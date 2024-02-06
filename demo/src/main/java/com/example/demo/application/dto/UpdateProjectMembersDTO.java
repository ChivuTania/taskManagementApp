package com.example.demo.application.dto;


public class UpdateProjectMembersDTO {
    String id;
    String member;
    String operation;

    public UpdateProjectMembersDTO(String id, String member) {
        this.id = id;
        this.member = member;
    }

    public String getId() {
        return id;
    }

    public String getMember() {
        return member;
    }

    public String getOperation() {
        return operation;
    }
}
