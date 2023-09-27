package com.cotiviiti.springclass.service;

import com.cotiviiti.springclass.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    void saveEmployee(Employee employee);
    void deleteEmployeeById(Long id);
    Employee updateEmployee(Employee employee);
}
