package com.cotiviiti.springclass.controller;


import com.cotiviiti.springclass.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @GetMapping("/employees")
    public String getEmployees(){
        List<Employee> data = new ArrayList<>();

        return "employees";
    }
}
