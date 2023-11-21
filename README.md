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
- AngularJS: for the frontend
- MongoDB: for the database
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
  - GET/project - to retrieve a list of all projects
  - GET/project/{id} - to retrieve a specific project by id
  - GET/sprint - to retrieve a list of all sprints
  - GET/sprint/{id} - to retrieve a specific sprint by id
  - GET/task - to retrieve a list of all tasks
  - GET/task/{id} - to retrieve a specific task by id
  
2. POST METHOD
  - POST/project - to add new project using DTOs
  - POST/sprint - to add a new sprint using DTOs
  - POST/task - to add a new sale using DTOs
3. PATCH METHOD
  - PATCH/project/member - to update an existing project's member
  - PATCH/project/{id}/sprint - to update an existing sprint in a specific project
  - PATCH/sprint/{id}/task - to update an existing sprint information
  - PATCH/sprint/{id} - to update an existing sprint with all the modified info (to be also updated in Project)
  - PATCH/task/owner - to update the owner of an existing task
  - PATCH/task/state - to update the state of an existing task
  - PATCH/task/{id} - to update an existing task with all the modified info (to be also updated in Sprints)
    
4. DELETE METHOD
  - DELETE/project/{id} - to delete a project by ID
  - DELETE/sprint/{id} - to delete a sprint by ID
  - DELETE/task/{id} - to delete a task by ID
