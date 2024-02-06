import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { AddTaskDTO } from 'src/app/models/dto/addTaskDTO';
import { UpdateSprintDTO } from 'src/app/models/dto/updateSprintDTO';
import { SprintService } from 'src/app/services/sprint.service';
import { TaskService } from 'src/app/services/task.service';

@Component({
  selector: 'app-create-task',
  templateUrl: './create-task.component.html',
  styleUrls: ['./create-task.component.css']
})
export class CreateTaskComponent {
  id: any
  message: any
  createTaskForm: FormGroup = new FormGroup({
    taskNameControl: new FormControl(''),
    descriptionControl: new FormControl(''),
    ownerControl: new FormControl(''),
    deadlineControl: new FormControl(''),
  });

  constructor(private sprintService: SprintService, private taskService: TaskService, public modal:NgbActiveModal){}
  ngOnInit(): void {
  }

  onSubmit() {

    let addTaskDTO: AddTaskDTO = {
      name: this.createTaskForm.controls['taskNameControl'].value,
      description: this.createTaskForm.controls['descriptionControl'].value,
      owner: this.createTaskForm.controls['ownerControl'].value,
      deadline:this.createTaskForm.controls['deadlineControl'].value,
      state: "TO DO",
      sprintName: ""
    }
    
    this.taskService.addNewTask(addTaskDTO)
    .subscribe((newTask) => {
      const createdTask = newTask;
      const dto: UpdateSprintDTO = {
        id: this.id,
        taskId: createdTask.id,
        operation: 'add'
    }
      
    console.log(createdTask.id)
    console.log(this.id);
    this.updateSprint(dto);
    this.modal.close()
    window.location.reload();
  });
  }

  updateSprint(dto: UpdateSprintDTO){
    this.sprintService.updateSprint(dto).subscribe((data) =>this.message = data)
  }
}
