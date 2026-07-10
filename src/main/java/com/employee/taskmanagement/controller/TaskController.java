package com.employee.taskmanagement.controller;

import com.employee.taskmanagement.model.Task;
import com.employee.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping
    public Collection<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/sorted/priority")
    public List<Task> getTasksSortedByPriority() {
        return taskService.getTasksSortedByPriority();
    }

    @GetMapping("/completed")
    public List<Task> getCompletedTasks() {
        return taskService.getCompletedTasks();
    }

    @GetMapping("/count-by-employee")
    public Map<Long, Long> getTaskCountPerEmployee() {
        return taskService.getTaskCountPerEmployee();
    }


    @GetMapping("/{taskId}")
    public Task getTaskById(@PathVariable Long taskId) {
        return taskService.getTaskById(taskId);
    }


    @PutMapping("/{taskId}/assign/{employeeId}")
    public Task assignTaskToEmployee(@PathVariable Long taskId,
                                     @PathVariable Long employeeId) {
        return taskService.assignTaskToEmployee(taskId, employeeId);
    }


    @PutMapping("/{taskId}/status")
    public Task updateTaskStatus(@PathVariable Long taskId,
                                 @RequestParam String status) {
        return taskService.updateTaskStatus(taskId, status);
    }


    @GetMapping("/employee/{employeeId}")
    public List<Task> getTasksByEmployee(@PathVariable Long employeeId) {
        return taskService.getTasksByEmployeeId(employeeId);
    }
}