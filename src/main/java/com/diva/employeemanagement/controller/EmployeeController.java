package com.diva.employeemanagement.controller;

import com.diva.employeemanagement.model.Employee;
import com.diva.employeemanagement.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping("/department/{dept}")
    public List<Employee> getByDepartment(@PathVariable String dept) {
        return service.getByDepartment(dept);
    }

    @GetMapping("/average-salary")
    public double getAverageSalary() {
        return service.getAverageSalary();
    }
}