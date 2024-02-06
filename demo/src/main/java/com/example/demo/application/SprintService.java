package com.example.demo.application;

import com.example.demo.application.dto.AddSprintDTO;

import com.example.demo.application.dto.UpdateSprintDTO1;
import com.example.demo.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SprintService {
    SprintRepository sprintRepository;
    TaskRepository taskRepository;
    ProjectRepository projectRepository;


    public SprintService(SprintRepository sprintRepository, TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.sprintRepository = sprintRepository;
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    public List<Sprint> getAllSprints() {
        Iterable<Sprint> sprintsIterable = this.sprintRepository.findAll();
        List<Sprint> sprintsList = StreamSupport.stream(sprintsIterable.spliterator(), false)
                .collect(Collectors.toList());
        return sprintsList;
    }

    public Sprint getSprintById(final String id){
        return this.sprintRepository.findById(id).get();
    }

    public void deleteSprint(final String id){
        this.sprintRepository.deleteById(id);
    }

    public void saveSprint(final Sprint sprint){
        this.sprintRepository.save(sprint);
    }

    public Sprint addSprint(final AddSprintDTO dto){
        final Sprint sprint = new Sprint(
                UUID.randomUUID().toString(),
                dto.getName(),
                dto.getDescription(),
                dto.getProjectName(),
                dto.getTasks()
        );
        this.sprintRepository.save(sprint);
        return sprint;
    }

    public void updateSprintTasks(final UpdateSprintDTO1 dto){
        final Sprint sprint = this.sprintRepository.findById(dto.getId()).get();
        final Task task = this.taskRepository.findById(dto.getTaskId()).get();
        final Project project = this.projectRepository.findByName(sprint.getProjectName());
        if(dto.getOperation().equals("add")){
            sprint.addTask(task);
            task.setSprint(sprint.getName());
        }
        else if(dto.getOperation().equals("delete")){
            sprint.deleteTask(task);
            task.deleteTaskFromSprint();
        }
        project.updateSprint(sprint);
        this.projectRepository.save(project);
        this.sprintRepository.save(sprint);
        this.taskRepository.save(task);


    }
}
