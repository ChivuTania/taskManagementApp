import { Task } from "../task.model";

export interface AddSprintDTO{
    name: string;
    description: string;
    tasks: Task[];
    projectName: string;
}