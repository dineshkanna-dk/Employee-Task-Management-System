package com.employee.taskmanagement.repository;

import com.employee.taskmanagement.model.Employee;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeRepository {


    private final Map<Long, Employee> employeeMap = new HashMap<>();

    public Employee save(Employee employee) {
        employeeMap.put(employee.getId(), employee);
        return employee;
    }

    public Collection<Employee> findAll() {
        return employeeMap.values();
    }

    public Employee findById(Long id) {
        return employeeMap.get(id);
    }

    public void deleteById(Long id) {
        employeeMap.remove(id);
    }

    public boolean existsById(Long id) {
        return employeeMap.containsKey(id);
    }
}