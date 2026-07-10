# Employee Task Management System

## Project Overview

The Employee Task Management System is a Spring Boot REST API application developed as part of the Java Developer Pre-Interview Technical Assignment.

The application helps manage employees, assign tasks, update task status, and generate reports. It follows Layered Architecture, REST API principles, Exception Handling, and Clean Coding Standards.

---

## Technologies Used

- Java 17
- Spring Boot
- Maven
- REST APIs
- Java Collections (HashMap)
- Java Streams
- IntelliJ IDEA
- Postman
- Git & GitHub

---

## Project Structure

```
src
 └── main
      ├── java
      │     └── com.employee.taskmanagement
      │            ├── controller
      │            ├── service
      │            ├── repository
      │            ├── model
      │            ├── exception
      │            └── TaskmanagementApplication
      │
      └── resources
             └── application.properties
```

---

## Features

### Employee Module

- Add Employee
- Get All Employees
- Get Employee By ID
- Delete Employee
- Find Highest Paid Employee
- Sort Employees by Salary

### Task Module

- Create Task
- Assign Task to Employee
- Update Task Status
- Get Tasks by Employee

### Reporting Module

- Get Completed Tasks
- Sort Tasks by Priority
- Count Tasks Per Employee

### Exception Handling

- Duplicate Employee Exception
- Employee Not Found Exception
- Duplicate Task Exception
- Task Not Found Exception
- Global Exception Handling

---

## REST API Endpoints

### Employee APIs

| Method | Endpoint |
|--------|----------|
| POST | /employees |
| GET | /employees |
| GET | /employees/{id} |
| DELETE | /employees/{id} |
| GET | /employees/highest-salary |
| GET | /employees/sort/salary |
| GET | /employees/{id}/tasks |

---

### Task APIs

| Method | Endpoint |
|--------|----------|
| POST | /tasks |
| GET | /tasks |
| GET | /tasks/{id} |
| PUT | /tasks/{taskId}/assign/{employeeId} |
| PUT | /tasks/{taskId}/status |
| GET | /tasks/completed |
| GET | /tasks/sort/priority |
| GET | /reports/task-count |

---

## Project Architecture

```
Client (Postman)

        │

        ▼

 Controller

        │

        ▼

  Service Layer

        │

        ▼

 Repository Layer

        │

        ▼

 In-Memory Storage (HashMap)
```

---

## How to Run the Project

1. Clone the repository

```
git clone https://github.com/dineshkanna-dk/Employee-Task-Management-System.git
```

2. Open the project in IntelliJ IDEA.

3. Wait for Maven dependencies to download.

4. Run

```
TaskmanagementApplication.java
```

5. Open Postman.

6. Test the REST APIs using

```
http://localhost:8080
```

---

## Assignment Requirements Covered

- Spring Boot
- REST APIs
- Layered Architecture
- Exception Handling
- Java Collections
- Java Streams
- Clean Coding Standards
- Proper Package Structure
- Reusable Methods
- Proper Naming Conventions

---

## Future Enhancements

- MySQL Database Integration
- Spring Data JPA
- Hibernate
- JWT Authentication
- Role-Based Access Control
- Swagger API Documentation
- Frontend Integration

---


## API Testing Screenshots

### Get All Employees

![Get All Employees](images/get-all-employees.png)

---

### Get All Tasks

![Get All Tasks](images/get-all-tasks.png)

---

### Completed Tasks

![Completed Tasks](images/completed-tasks.png)

---

### Highest Paid Employee

![Highest Paid Employee](images/highest-salary.png)

---

### Task Count Report

![Task Count](images/task-count.png)

---

### Exception Handling

![Exception Handling](images/exception.png)

## Author

**Dineshkanna M**

Java Full Stack Developer

GitHub:
https://github.com/dineshkanna-dk

---

## Thank You
