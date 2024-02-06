package com.example.demo.application;

import com.example.demo.application.dto.AddTaskDTO;
import com.example.demo.application.dto.UpdateTaskStateDTO;
import com.example.demo.domain.Sprint;
import com.example.demo.domain.SprintRepository;
import com.example.demo.domain.Task;
import com.example.demo.domain.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskService {

    TaskRepository taskRepository;
    SprintRepository sprintRepository;

    public TaskService(TaskRepository taskRepository, SprintRepository sprintRepository) {
        this.taskRepository = taskRepository;
        this.sprintRepository = sprintRepository;
    }

    public List<Task> getAllTasks() {
        Iterable<Task> tasksIterable = this.taskRepository.findAll();
        List<Task> tasksList = StreamSupport.stream(tasksIterable.spliterator(), false)
                .collect(Collectors.toList());
        return tasksList;
    }

    public Task getTaskById(String id){
        return this.taskRepository.findById(id).get();
    }

    public void deleteTask(String id){
        this.taskRepository.deleteById(id);
    }

    public Task addTask(final AddTaskDTO dto){
        final Task task = new Task(
                UUID.randomUUID().toString(),
                dto.getName(),
                dto.getDescription(),
                dto.getOwner(),
                dto.getDeadline(),
                dto.getState(),
                dto.getSprint()
        );
        this.taskRepository.save(task);
        return task;
    }

    public void updateTaskOwner(final String id, final String owner){
        final Task task = this.taskRepository.findById(id).get();
        task.setOwner(owner);
        this.taskRepository.save(task);
    }

    public void saveTask(final Task task){
        this.taskRepository.save(task);
    }

    public void updateTaskState(final UpdateTaskStateDTO dto){
        final Task task = this.taskRepository.findById(dto.getId()).get();
        task.setState(dto.getState());
        this.taskRepository.save(task);
        final Sprint sprint = this.sprintRepository.findByName(task.getSprint());
        sprint.setSprintTaskState(sprint,task,dto.getState());
        this.sprintRepository.save(sprint);
    }
}
