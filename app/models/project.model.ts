import { Sprint } from "./sprint.model";

export interface Project{
    id: string;
    name: string;
    description: string;
    sprints: Sprint[];
    members: string[];
}