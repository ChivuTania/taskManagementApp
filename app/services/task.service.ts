import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from '../models/task.model';
import { AddTaskDTO } from '../models/dto/addTaskDTO';
import { UpdateTaskStateDTO } from '../models/dto/updateTaskState';


@Injectable({
  providedIn: 'root'
})
export class TaskService {private readonly Task_URL = "http://localhost:8080/task";

constructor(private httpClient: HttpClient) { }

getAllTasks(): Observable<Task[]>{
  return this.httpClient.get<Task[]>(this.Task_URL);
}

addNewTask(addTaskDTO : AddTaskDTO): Observable<Task>{
  return this.httpClient.post<Task>(this.Task_URL,addTaskDTO);
}

getTaskById(taskId: string): Observable<Task>{
  return this.httpClient.get<Task>(`${this.Task_URL}/${taskId}`);
}

updateTaskState(dto: UpdateTaskStateDTO): Observable<void> {
  return this.httpClient.patch<void>(`${this.Task_URL}/state`, dto);
  }

  saveTask(task: Task): Observable<void> {
    return this.httpClient.patch<void>(`${this.Task_URL}/${task.id}`, task);
  }
}




// removeTask(taskId: string): Observable<void>{
//   return this.httpClient.delete<void>(`${this.Task_URL}/${taskId}`);
// }

// editEmployee(modifyEmployeeDTO: ModifyEmployeeDTO): Observable<void>{
//   return this.httpClient.patch<void>(this.Task_URL, modifyEmployeeDTO);
// }

