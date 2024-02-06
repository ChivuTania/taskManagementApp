package com.example.demo.domain;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


import java.util.List;
import java.util.Objects;

@Document(indexName = "sprints")
public class Sprint {
    @Id
    @Field(type = FieldType.Keyword)
    String id;
    @Field(type = FieldType.Text)
    String name;
    @Field(type = FieldType.Text)
    String description;
    @Field(type = FieldType.Nested)
    List<Task> tasks;
    @Field(type = FieldType.Text)
    String projectName;

    public Sprint(String id, String name, String description, String projectName,List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.projectName = projectName;
        this.tasks = tasks;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public String getProjectName() {
        return projectName;
    }

    public void addTask(Task task) {
        if(!tasks.contains(task)){
            tasks.add(task);
        }
    }

    public void deleteTask(Task task){
        tasks.remove(task);
    }

    public void setProjectName(String projectName){
        this.projectName = projectName;
    }

    public void setSprintTaskState(Sprint sprint, Task task, String state){
        int index = sprint.tasks.indexOf(task);
        Task taskToUpdate = sprint.tasks.get(index);
        taskToUpdate.setState(state);
    }

    public void deleteSprintFromProject(){
        this.projectName = "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sprint task = (Sprint) o;
        return Objects.equals(id, task.id);
    }
}
