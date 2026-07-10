package com.employee.taskmanagement.controller;

import com.employee.taskmanagement.model.Employee;
import com.employee.taskmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.employee.taskmanagement.model.Task;
import com.employee.taskmanagement.service.TaskService;
import java.util.List;
import java.util.Collection;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private TaskService taskService;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully.";
    }
    @GetMapping("/sorted/salary")
    public List<Employee> getEmployeesSortedBySalary() {
        return employeeService.getEmployeesSortedBySalary();
    }
    // Get Highest Paid Employee
    @GetMapping("/highest-salary")
    public Employee getHighestPaidEmployee() {
        return employeeService.getHighestPaidEmployee();
    }
    @GetMapping("/{id}/tasks")
    public List<Task> getEmployeeTasks(@PathVariable Long id) {
        return taskService.getTasksByEmployeeId(id);
    }
}