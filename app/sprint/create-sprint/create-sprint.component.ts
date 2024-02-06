import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, Subscription } from 'rxjs';
import { AddSprintDTO } from 'src/app/models/dto/addSprintDTO';
import { UpdateProjectSprintDTO } from 'src/app/models/dto/updateProjectSprintDTO';
import { Project } from 'src/app/models/project.model';
import { Sprint } from 'src/app/models/sprint.model';
import { ProjectService } from 'src/app/services/project.service';
import { SprintService } from 'src/app/services/sprint.service';

@Component({
  selector: 'app-create-sprint',
  templateUrl: './create-sprint.component.html',
  styleUrls: ['./create-sprint.component.css']
})
export class CreateSprintComponent {
  id: any
  createSprintForm: FormGroup = new FormGroup({
    sprintNameControl: new FormControl(''),
    descriptionControl: new FormControl('')
  });

  constructor(private route: ActivatedRoute, private sprintService: SprintService, private projectService: ProjectService, public modal:NgbActiveModal) { }
  message: any
  paramsSubscription: Subscription | undefined;
  ngOnInit(): void {
  }


  onSubmit() {

    let addSprintDTO: AddSprintDTO = {
      name: this.createSprintForm.controls['sprintNameControl'].value,
      description: this.createSprintForm.controls['descriptionControl'].value,
      tasks: [],
      projectName: ""
    } 


    this.sprintService.addNewSprint(addSprintDTO)
    .subscribe((newSprint) => {
      const createdSprint = newSprint;
      const dto: UpdateProjectSprintDTO = {
        id: this.id,
        sprintId: createdSprint.id,
        operation: 'add'
    }
    console.log(this.id)
    this.updateProjectSprint(dto);
    this.modal.close()
    window.location.reload();
  });
  }

  updateProjectSprint(dto: UpdateProjectSprintDTO){
    this.projectService.updateProjectSprint(dto).subscribe((data) =>this.message = data)
  }
}


