package com.example.demo.interfaces;

import com.example.demo.application.TaskService;
import com.example.demo.application.dto.AddTaskDTO;
import com.example.demo.application.dto.UpdateTaskOwnerDTO1;
import com.example.demo.application.dto.UpdateTaskStateDTO;
import com.example.demo.domain.Sprint;
import com.example.demo.domain.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TaskRestController {
    TaskService taskService;

    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task")
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok(this.taskService.getAllTasks());
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> getTaskById(final @PathVariable String id){
        return ResponseEntity.ok(this.taskService.getTaskById(id));
    }

    @PostMapping("/task")
    public ResponseEntity<Task> createTask(final @RequestBody AddTaskDTO dto){
        Task task = this.taskService.addTask(dto);
        return ResponseEntity.ok(task);
    }


    @PatchMapping("/task/owner")
    public ResponseEntity<Void> updateTaskOwner(final @RequestBody UpdateTaskOwnerDTO1 dto){
        this.taskService.updateTaskOwner(dto.getId(),dto.getOwner());
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/task/state")
    public ResponseEntity<Void> updateTaskState(final @RequestBody UpdateTaskStateDTO dto){
        this.taskService.updateTaskState(dto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/task/{id}")
    ResponseEntity<Void> saveSprintTaskState(final @PathVariable String id, final @RequestBody Task task){
        this.taskService.saveTask(task);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<Void> deleteTask(final @RequestBody String id){
        this.taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
