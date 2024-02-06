package com.example.demo.interfaces;

import com.example.demo.application.SprintService;
import com.example.demo.application.dto.AddSprintDTO;
import com.example.demo.application.dto.UpdateSprintDTO1;
import com.example.demo.domain.Sprint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SprintRestController {
    SprintService sprintService;


    public SprintRestController(SprintService sprintService) {
        this.sprintService = sprintService;
    }

    @GetMapping("/sprint")
    ResponseEntity<List<Sprint>> getAllSprints(){
        return ResponseEntity.ok(this.sprintService.getAllSprints());
    }

    @GetMapping("/sprint/{id}")
    ResponseEntity<Sprint> getSprintById(final @PathVariable String id){
        return ResponseEntity.ok(this.sprintService.getSprintById(id));
    }

    @PostMapping("/sprint")
    ResponseEntity<Sprint> addSprint(final @RequestBody AddSprintDTO dto){
        Sprint sprint = this.sprintService.addSprint(dto);
        return ResponseEntity.ok(sprint);
    }

    @PatchMapping("/sprint/{id}/task")
    ResponseEntity<Void> updateSprint(final @PathVariable String id,  final @RequestBody UpdateSprintDTO1 dto){
        this.sprintService.updateSprintTasks(dto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/sprint/{id}")
    ResponseEntity<Void> saveSprintTaskState(final @PathVariable String id, final @RequestBody Sprint sprint){
        this.sprintService.saveSprint(sprint);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/sprint/{id}")
    ResponseEntity<Void> deleteSprint(final @PathVariable String id){
        this.sprintService.deleteSprint(id);
        return ResponseEntity.ok().build();
    }
}
