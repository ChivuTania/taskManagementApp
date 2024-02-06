import { Component } from '@angular/core';
import { Project } from 'src/app/models/project.model';
import { ProjectService } from 'src/app/services/project.service';
import { CreateProjectComponent } from '../create-project/create-project.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent {
  allProjects: Project[] = [];

  constructor(private projectService: ProjectService, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.initializeProjects()
  }

  private initializeProjects() {
    this.projectService.getAllProjects()
    .subscribe((projects) => {
      this.allProjects = projects;
    });
  }

  openCreateEditModal(){
    let modalRef = this.modalService.open(CreateProjectComponent, {size: 'xl'});
    modalRef.result.then((response) => this.initializeProjects());
  }

}
