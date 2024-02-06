import { Component, OnInit } from '@angular/core';
import { Task } from 'src/app/models/task.model';
import { TaskService } from 'src/app/services/task.service';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit{
  allTasks: Task[] = [];

  constructor(private taskService: TaskService) { }

  ngOnInit(): void {
    this.taskService.getAllTasks()
    .subscribe((result: Task[]) => {
      this.allTasks = result
    })
  }

  getInitial(task : Task):String{
      return task.owner.split(' ')
      .map((name) => name.charAt(0))
      .join('');
  }

}
