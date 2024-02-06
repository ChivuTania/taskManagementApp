package com.example.demo.application;

import com.example.demo.application.dto.AddProjectDTO;
import com.example.demo.application.dto.UpdateProjectMembersDTO;
import com.example.demo.application.dto.UpdateProjectSprintDTO;
import com.example.demo.domain.Project;
import com.example.demo.domain.ProjectRepository;
import com.example.demo.domain.Sprint;
import com.example.demo.domain.SprintRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProjectService {

    ProjectRepository projectRepository;
    SprintRepository sprintRepository;

    public ProjectService(ProjectRepository projectRepository, SprintRepository sprintRepository) {
        this.projectRepository = projectRepository;
        this.sprintRepository = sprintRepository;
    }

    public List<Project> getAllProjects() {
        Iterable<Project> projectsIterable = this.projectRepository.findAll();
        List<Project> projectsList = StreamSupport.stream(projectsIterable.spliterator(), false)
                .collect(Collectors.toList());
        return projectsList;
    }

    public Project getProjectById(final String id){
        return this.projectRepository.findById(id).get();
    }

    public void addProject(final AddProjectDTO dto){
        final Project project = new Project(
                UUID.randomUUID().toString(),
                dto.getName(),
                dto.getDescription(),
                dto.getSprint(),
                dto.getMembers()
        );
        this.projectRepository.save(project);
    }

    public void updateProjectMember(final UpdateProjectMembersDTO dto){
        final Project project = this.projectRepository.findById(dto.getId()).get();
        if(dto.getOperation().equals("add")){
            project.addMember(dto.getMember());
        }
        else if(dto.getOperation().equals("delete")){
            project.deleteMember(dto.getMember());
        }
        this.projectRepository.save(project);
    }

    public void updateProjectSprint(final UpdateProjectSprintDTO dto){
        final Project project = this.projectRepository.findById(dto.getId()).get();
        final Sprint sprint = this.sprintRepository.findById(dto.getSprintId()).get();
        if(dto.getOperation().equals("add")){
            project.addSprint(sprint);
            sprint.setProjectName(project.getName());
        }
        else if(dto.getOperation().equals("delete")){
            project.deleteSprint(sprint);
            sprint.deleteSprintFromProject();
            System.out.println(project.getSprints());
            System.out.println(sprint);
        }
        this.projectRepository.save(project);
        this.sprintRepository.save(sprint);
    }

    public void deleteProject(final String id){
        this.projectRepository.deleteById(id);
    }
}
