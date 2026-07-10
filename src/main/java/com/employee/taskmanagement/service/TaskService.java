package com.employee.taskmanagement.service;

import com.employee.taskmanagement.model.Employee;
import com.employee.taskmanagement.model.Task;
import com.employee.taskmanagement.repository.EmployeeRepository;
import com.employee.taskmanagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.taskmanagement.exception.DuplicateTaskException;
import com.employee.taskmanagement.exception.TaskNotFoundException;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    public Task createTask(Task task) {

        if (taskRepository.existsById(task.getTaskId())) {
            throw new DuplicateTaskException("Task ID already exists.");
        }

        return taskRepository.save(task);
    }

    public Collection<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long taskId) {

        Task task = taskRepository.findById(taskId);

        if (task == null) {
            throw new TaskNotFoundException("Task not found.");
        }

        return task;
    }


    public Task assignTaskToEmployee(Long taskId, Long employeeId) {

        Task task = getTaskById(taskId);

        Employee employee = employeeRepository.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee not found.");
        }

        task.setAssignedEmployeeId(employeeId);

        return taskRepository.save(task);
    }


    public Task updateTaskStatus(Long taskId, String status) {

        Task task = getTaskById(taskId);

        task.setStatus(status);

        return taskRepository.save(task);
    }


    public List<Task> getTasksByEmployeeId(Long employeeId) {

        return taskRepository.findAll()
                .stream()
                .filter(task -> employeeId.equals(task.getAssignedEmployeeId()))
                .collect(Collectors.toList());
    }


    public List<Task> getTasksSortedByPriority() {

        Map<String, Integer> priorityOrder = Map.of(
                "HIGH", 1,
                "MEDIUM", 2,
                "LOW", 3
        );

        return taskRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(task ->
                        priorityOrder.getOrDefault(task.getPriority(), 4)))
                .collect(Collectors.toList());
    }


    public List<Task> getCompletedTasks() {

        return taskRepository.findAll()
                .stream()
                .filter(task -> "COMPLETED".equalsIgnoreCase(task.getStatus()))
                .collect(Collectors.toList());
    }
    
    public Map<Long, Long> getTaskCountPerEmployee() {

        return taskRepository.findAll()
                .stream()
                .filter(task -> task.getAssignedEmployeeId() != null)
                .collect(Collectors.groupingBy(
                        Task::getAssignedEmployeeId,
                        Collectors.counting()
                ));
    }

}