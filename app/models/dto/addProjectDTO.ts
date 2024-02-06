import { Sprint } from "../sprint.model";

export interface AddProjectDTO{
    name: string;
    description: string;
    sprints: Sprint[];
    members: string[];
}