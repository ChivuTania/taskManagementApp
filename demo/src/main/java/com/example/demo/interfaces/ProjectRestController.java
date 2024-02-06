package com.example.demo.interfaces;

import com.example.demo.application.ProjectService;
import com.example.demo.application.dto.AddProjectDTO;
import com.example.demo.application.dto.UpdateProjectMembersDTO;
import com.example.demo.application.dto.UpdateProjectSprintDTO;
import com.example.demo.domain.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProjectRestController {

    ProjectService projectService;

    public ProjectRestController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/project")
    ResponseEntity<List<Project>> getAllProjects(){
        return ResponseEntity.ok(this.projectService.getAllProjects());
    }

    @GetMapping("/project/{id}")
    ResponseEntity<Project> getProjectById(final @PathVariable String id){
        return ResponseEntity.ok(this.projectService.getProjectById(id));
    }

    @PostMapping("/project")
    ResponseEntity<Void> addProject(final @RequestBody AddProjectDTO dto){
        this.projectService.addProject(dto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/project/member")
    ResponseEntity<Void> updateProjectMember(final @RequestBody UpdateProjectMembersDTO dto){
        this.projectService.updateProjectMember(dto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/project/{id}/sprint")
    ResponseEntity<Void> updateProjectSprint(final @PathVariable String id, final @RequestBody UpdateProjectSprintDTO dto){
        this.projectService.updateProjectSprint(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/project/{id}")
    ResponseEntity<Void> deleteProject(final @PathVariable String id){
        this.projectService.deleteProject(id);
        return ResponseEntity.ok().build();
    }
}
