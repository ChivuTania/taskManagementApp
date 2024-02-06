import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TaskListComponent } from './task/task-list/task-list.component';
import { HeaderComponent } from './header/header.component';
import { ProjectListComponent } from './project/project-list/project-list.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CreateProjectComponent } from './project/create-project/create-project.component';
import { IndividualProjectComponent } from './project/individual-project/individual-project.component';
import { IndividualSprintComponent } from './sprint/individual-sprint/individual-sprint.component';
import { CreateSprintComponent } from './sprint/create-sprint/create-sprint.component';
import { CreateTaskComponent } from './task/create-task/create-task.component';
import { IndividualTaskComponent } from './task/individual-task/individual-task.component';

@NgModule({
  declarations: [
    AppComponent,
    TaskListComponent,
    HeaderComponent,
    ProjectListComponent,
    CreateProjectComponent,
    IndividualProjectComponent,
    IndividualSprintComponent,
    CreateSprintComponent,
    CreateTaskComponent,
    IndividualTaskComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
