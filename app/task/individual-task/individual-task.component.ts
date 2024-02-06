import { HttpClient } from '@angular/common/http';
import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { UpdateTaskStateDTO } from 'src/app/models/dto/updateTaskState';
import { Sprint } from 'src/app/models/sprint.model';
import { Task } from 'src/app/models/task.model';
import { SprintService } from 'src/app/services/sprint.service';
import { TaskService } from 'src/app/services/task.service';

@Component({
  selector: 'app-individual-task',
  templateUrl: './individual-task.component.html',
  styleUrls: ['./individual-task.component.css']
})
export class IndividualTaskComponent {
  selectedState: string = ''
	// onSelected(value:string): void {
	// 	this.selectedState = value;
	// }


id: any
sprintId: any
constructor(public modal:NgbActiveModal, private taskService: TaskService, private httpClient: HttpClient, private sprintService: SprintService, private route: ActivatedRoute){}
  task!: Task
  isEditMode = false;
  sprint!: Sprint;
  message: any


  ngOnInit(): void {
    this.initializeTask()
  }


  private initializeTask() {
    this.taskService.getTaskById(this.id)
    .subscribe((task?: Task) => {
      if (task) {
        this.task = task;
      }
    });
  }


  toggleEdit() {
    this.isEditMode = !this.isEditMode;
  }



  saveChanges() {
    if(this.selectedState ){
      const dto: UpdateTaskStateDTO = {
        id: this.id,
        state: this.selectedState
      };
  
      this.taskService.updateTaskState(dto).subscribe((data)=>this.message=data)
      this.modal.close();
      this.task.state = this.selectedState
      window.location.reload();
    }
    
}

  closeModal() {
    this.isEditMode = !this.isEditMode
    this.modal.close()
  }

}