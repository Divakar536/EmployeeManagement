package com.diva.employeemanagement.service;

import com.diva.employeemanagement.model.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private List<Employee> employees = Arrays.asList(
            new Employee(101,"Diva","IT",65000,LocalDate.of(2014,6,14)),
            new Employee(102,"Nani","Finance",15000,LocalDate.of(2010,3,19)),
            new Employee(103,"Hari","HR",45000,LocalDate.of(2014,6,12)),
            new Employee(104,"Ravi","IT",85000,LocalDate.of(2008,6,10)),
            new Employee(105,"Chin","HR",55000,LocalDate.of(2018,6,14))
    );

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public List<Employee> getByDepartment(String dept) {
        return employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase(dept))
                .collect(Collectors.toList());
    }

    public double getAverageSalary() {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }
}