import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Project } from '../models/project.model';
import { AddProjectDTO } from '../models/dto/addProjectDTO';
import { UpdateProjectSprintDTO } from '../models/dto/updateProjectSprintDTO';
import { SprintService } from './sprint.service';
import { Sprint } from '../models/sprint.model';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  private readonly Project_URL = "http://localhost:8080/project";
  private readonly Project_Sprint_URL = "http://localhost:8080/project"

constructor(private httpClient: HttpClient, private sprintService: SprintService) { }

getAllProjects(): Observable<Project[]>{
  return this.httpClient.get<Project[]>(this.Project_URL);
}

addNewProject(addProjectDTO: AddProjectDTO): Observable<void> {
  return this.httpClient.post<void>(this.Project_URL, addProjectDTO);
}

getProjectById(projectId: string): Observable<Project>{
  return this.httpClient.get<Project>(`${this.Project_URL}/${projectId}`);
  
}

updateProjectSprint(dto: UpdateProjectSprintDTO): Observable<void> {
  return this.httpClient.patch<void>(`${this.Project_Sprint_URL}/${dto.id}/sprint`, dto);
  }
}
