# ProjectManagementApp


# OVERVIEW
The chosen theme for this project is a Project Management Application where team members 
can sort out their tasks, create new issues and track their progress. It will mimic some of the behaviors of other 
well-known management platforms such as Jira and it will follow a structure of Projects, Sprints and finally Tasks. Its desired main functionalities would be:
- Create new Projects
- Create new Sprints
- Add Sprints to Projects
- Create new Tasks
- Add Tasks to Sprints
- Edit Task state (Open,In progress, In review, Done)
- Edit Task owner
  
# TECHNOLOGIES TO BE USED 
This App will be designed using:
- Spring: for the backend
- Angular: for the frontend
- Elasticsearch

# DESIGNING REST API

For the backend, the models chosen are: Task, Sprint and Project which are in a hierarchical 
relationship. This relationship reflects a common project management structure where tasks are 
grouped into sprints, and sprints are further organized within projects.
The hierarchical relationship can be represented as follows:
- A Project can have multiple Sprints.
- A Sprint can have multiple Tasks.
- Each Task belongs to a specific Sprint.

In order to implement all the functionalities, these REST API methods will be used: 
1. GET METHOD
  - GET/projects - to retrieve a list of all projects
  - GET/projects/{id} - to retrieve a specific project by id
  - GET/sprints - to retrieve a list of all sprints
  - GET/sprints/{id} - to retrieve a specific sprint by id
  - GET/tasks - to retrieve a list of all tasks
  - GET/tasks/{id} - to retrieve a specific task by id

2. POST METHOD
  - POST/projects - to add new project using DTOs
  - POST/sprints - to add a new sprint using DTOs
  - POST/tasks - to add a new sale using DTOs
    
3. PATCH METHOD
  - PATCH/projects/{id} - to update an existing project (update the Sprints and Tasks that are modified in that project)
  - PATCH/sprints/{id} - to update an existing sprint (update the Tasks that are modified in that Sprint)
  - PATCH/tasks/{id}/owner - to update the owner of an existing task
  - PATCH/tasks/{id}/state - to update the state of an existing task
  - PATCH/tasks/{id} - to update an existing task with all the modified info 
    
4. DELETE METHOD
  - DELETE/projects/{id} - to delete a project by ID
  - DELETE/sprints/{id} - to delete a sprint by ID
  - DELETE/tasks/{id} - to delete a task by ID
