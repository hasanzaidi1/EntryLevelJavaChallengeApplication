package com.challenge.api.service;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeImpl;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        employees.add(new EmployeeImpl(UUID.randomUUID(), "Bob", "Marly", 80000, 35, "Database Engineer", "bobMarly@yahoo.com", Instant.now()));
        employees.add(new EmployeeImpl(UUID.randomUUID(), "Alec", "Baldwin", 70000, 45, "QA Engineer", "alec@gmail.com", Instant.now()));
        employees.add(new EmployeeImpl(UUID.randomUUID(), "Judie", "Smith", 60000, 24, "Software Engineer", "jude@gmail.com", Instant.now()));
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeByUuid(UUID uuid) {
        return employees.stream()
                .filter(emp -> emp.getUuid().equals(uuid))  
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }
    

    public Employee createEmployee(String firstName, String lastName, Integer salary, Integer age, String jobTitle, String email, Instant contractHireDate) {
        Employee newEmployee = new EmployeeImpl(UUID.randomUUID(), firstName, lastName, salary, age, jobTitle, email, contractHireDate);
        employees.add(newEmployee);
        return newEmployee;
    }
}
