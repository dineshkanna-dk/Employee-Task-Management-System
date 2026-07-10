package com.employee.taskmanagement.service;

import com.employee.taskmanagement.exception.DuplicateEmployeeException;
import com.employee.taskmanagement.exception.EmployeeNotFoundException;
import com.employee.taskmanagement.model.Employee;
import com.employee.taskmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collection;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {

        if (employeeRepository.existsById(employee.getId())) {
            throw new DuplicateEmployeeException("Employee ID already exists.");
        }

        return employeeRepository.save(employee);
    }

    public Collection<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id);

        if (employee == null) {
            throw new EmployeeNotFoundException("Employee not found.");
        }

        return employee;
    }

    public void deleteEmployee(Long id) {

        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee not found.");
        }

        employeeRepository.deleteById(id);
    }

    public List<Employee> getEmployeesSortedBySalary() {

        return employeeRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());
    }

    public Employee getHighestPaidEmployee() {

        return employeeRepository.findAll()
                .stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }
}