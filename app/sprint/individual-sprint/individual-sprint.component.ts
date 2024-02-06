import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Sprint } from 'src/app/models/sprint.model';
import { Task } from 'src/app/models/task.model';
import { ProjectService } from 'src/app/services/project.service';
import { SprintService } from 'src/app/services/sprint.service';
import { CreateTaskComponent } from 'src/app/task/create-task/create-task.component';
import { IndividualTaskComponent } from 'src/app/task/individual-task/individual-task.component';

@Component({
  selector: 'app-individual-sprint',
  templateUrl: './individual-sprint.component.html',
  styleUrls: ['./individual-sprint.component.css']
})
export class IndividualSprintComponent {
  sprint!: Sprint;
  // paramsSubscription: Subscription | undefined;

  constructor(private router: Router, private route: ActivatedRoute, private sprintService: SprintService, private modalService: NgbModal) {}
  ngOnInit() {
    this.route.params.subscribe(params=>{
      let id = params['id'];
      this.sprintService.getSprintById(id).subscribe((sprint) => {
      this.sprint = sprint;
    });
    })
  }

  openCreateEditModal(){
    let modalRef = this.modalService.open(CreateTaskComponent, {size: 'xl'});
    this.route.params.subscribe(params=>{
      let id: string = params['id'];
      modalRef.componentInstance.id = id; })
    modalRef.result.then();
  }

  getInitial(task : Task):String{
    return task.owner.split(' ')
    .map((name) => name.charAt(0))
    .join('');
}

openModal(task: Task) {
  let modalRef = this.modalService.open(IndividualTaskComponent, {size: 'xl'});
  modalRef.componentInstance.id = task.id;
  this.route.params.subscribe(params=>{
    let id: string = params['id'];
    modalRef.componentInstance.sprintId = id;
    console.log(id)})
  modalRef.result.then();
  
}

}
