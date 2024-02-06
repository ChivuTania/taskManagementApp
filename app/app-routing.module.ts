import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TaskListComponent } from './task/task-list/task-list.component';
import { ProjectListComponent } from './project/project-list/project-list.component';
import { IndividualProjectComponent } from './project/individual-project/individual-project.component';
import { IndividualSprintComponent } from './sprint/individual-sprint/individual-sprint.component';
import { IndividualTaskComponent } from './task/individual-task/individual-task.component';

const routes: Routes = [
  {path: "task", component: TaskListComponent},
  {path: "", component: ProjectListComponent},
  { path: "project/:id", component: IndividualProjectComponent },
  { path: "sprint/:id", component: IndividualSprintComponent },
  // { path: "task/:id", component: IndividualTaskComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
