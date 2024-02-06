import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { AddProjectDTO } from 'src/app/models/dto/addProjectDTO';
import { ProjectService } from 'src/app/services/project.service';



@Component({
  selector: 'app-create-project',
  templateUrl: './create-project.component.html',
  styleUrls: ['./create-project.component.css']
})
export class CreateProjectComponent implements OnInit{
  createProjectForm: FormGroup = new FormGroup({
    projectNameControl: new FormControl(''),
    descriptionControl: new FormControl('')
  });

  constructor(private projectService: ProjectService, public modal:NgbActiveModal) { }

  ngOnInit(): void {
  }


  onSubmit() {

    let addProjectDTO: AddProjectDTO = {
      name: this.createProjectForm.controls['projectNameControl'].value,
      description: this.createProjectForm.controls['descriptionControl'].value,
      sprints: [],
      members: []
    } 
    this.projectService.addNewProject(addProjectDTO)
    .subscribe(() => this.modal.close());
  }

}
