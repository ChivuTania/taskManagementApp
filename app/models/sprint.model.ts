import { Task } from "./task.model";

export interface Sprint{
    id: string;
    name: string;
    description: string;
    tasks: Task[];
    projectName: string;
}