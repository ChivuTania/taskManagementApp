import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Subscription } from 'rxjs';
import { Project } from 'src/app/models/project.model';
import { ProjectService } from 'src/app/services/project.service';
import { CreateSprintComponent } from 'src/app/sprint/create-sprint/create-sprint.component';

@Component({
  selector: 'app-individual-project',
  templateUrl: './individual-project.component.html',
  styleUrls: ['./individual-project.component.css']
})
export class IndividualProjectComponent {
  project!: Project;
  paramsSubscription: Subscription | undefined;

  constructor(private route: ActivatedRoute, private projectService: ProjectService, private modalService: NgbModal) {}
  ngOnInit() {
    this.route.params.subscribe(params=>{
      let id = params['id'];
      this.projectService.getProjectById(id).subscribe((project) => {
      this.project = project;
    });
    })
  }

  openCreateEditModal(){
    let modalRef = this.modalService.open(CreateSprintComponent, {size: 'xl'});
    this.route.params.subscribe(params=>{
      let id: string = params['id'];
      modalRef.componentInstance.id = id; })
    modalRef.result.then();
  }
}
