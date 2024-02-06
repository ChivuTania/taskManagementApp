package com.example.demo.domain;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


import java.util.List;
import java.util.Objects;

@Document(indexName = "tasks")
public class Project {
    @Id
    @Field(type = FieldType.Keyword)
    String id;
    @Field(type = FieldType.Text)
    String name;
    @Field(type = FieldType.Text)
    String description;
    @Field(type = FieldType.Nested)
    List<Sprint> sprints;
    @Field(type = FieldType.Text)
    List<String> members;

    public Project(String id, String name, String description, List<Sprint> sprints, List<String> members) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sprints = sprints;
        this.members = members;
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

    public List<Sprint> getSprints() {
        return sprints;
    }

    public List<String> getMembers() {
        return members;
    }

    public void addMember(String member){
        members.add(member);
    }

    public void deleteMember(String member){
        members.remove(member);
    }

    public void addSprint(Sprint sprint){
        sprints.add(sprint);
    }

    public void deleteSprint(Sprint sprint){
        sprints.remove(sprint);
    }

    public void updateSprint(Sprint sprint){
        sprints.remove(sprint);
        sprints.add(sprint);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }
}
