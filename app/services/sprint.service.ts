import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Sprint } from '../models/sprint.model';
import { AddSprintDTO } from '../models/dto/addSprintDTO';
import { UpdateSprintDTO } from '../models/dto/updateSprintDTO';

@Injectable({
  providedIn: 'root'
})
export class SprintService {private readonly Sprint_URL = "http://localhost:8080/sprint";

constructor(private httpClient: HttpClient) { }

getAllSprints(): Observable<Sprint[]>{
  return this.httpClient.get<Sprint[]>(this.Sprint_URL);
}

getSprintById(sprintId: string): Observable<Sprint>{
  return this.httpClient.get<Sprint>(`${this.Sprint_URL}/${sprintId}`);
}

addNewSprint(addSprintDTO: AddSprintDTO): Observable<Sprint> {
  return this.httpClient.post<Sprint>(this.Sprint_URL, addSprintDTO);
}

updateSprint(dto: UpdateSprintDTO): Observable<void> {
  return this.httpClient.patch<void>(`${this.Sprint_URL}/${dto.id}/task`, dto);
}

saveSprint(sprint: Sprint): Observable<void> {
  return this.httpClient.patch<void>(`${this.Sprint_URL}/${sprint.id}`, sprint);
}
}
