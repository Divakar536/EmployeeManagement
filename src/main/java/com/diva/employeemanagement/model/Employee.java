package com.diva.employeemanagement.model;

import java.time.LocalDate;

public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private LocalDate joinDate;

    // Constructors, Getters, Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public Employee(int id, String name, String department, double salary, LocalDate joinDate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.joinDate = joinDate;
    }
}