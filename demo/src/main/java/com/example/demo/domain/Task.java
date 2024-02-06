package com.example.demo.domain;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


import java.util.Objects;

@Document(indexName = "tasks")
public class Task {
    @Id
    @Field(type = FieldType.Keyword)
    String id;
    @Field(type = FieldType.Text)
    String name;
    @Field(type = FieldType.Text)
    String description;
    @Field(type = FieldType.Text)
    String owner;
    @Field(type = FieldType.Text)
    String deadline;
    @Field(type = FieldType.Text)
    String state;
    @Field(type = FieldType.Text)
    String sprintName;

    public Task(String id, String name, String description, String owner, String deadline, String state, String sprintName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.deadline = deadline;
        this.state = state;
        this.sprintName = sprintName;
    }

    public String getId() {
        return id;
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

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setSprint(String sprintName) {
        this.sprintName = sprintName;
    }

    public void deleteTaskFromSprint(){
        this.sprintName = "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }
}
