package com.cotiviiti.springclass.controller;


import com.cotiviiti.springclass.entity.Employee;
import com.cotiviiti.springclass.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

//    @GetMapping
//    public ResponseEntity<List<Employee>> getAllEmployees() {
//        List<Employee> employees = employeeService.getAllEmployees();
//        return new ResponseEntity<>(employees, HttpStatus.OK);
//    }

    @GetMapping("/employees")
   public String getEmployees(Model model){
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }

    @PostMapping("/employee")
    public String saveEmployee( @ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employee/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model){
        model.addAttribute("employee",employeeService.getEmployeeById(id));
        return "edit_employee";
    }

    @PostMapping("/employee/update/{id}")
    public String updateEmployee(@PathVariable Long id, Employee employee){
        Employee oldEmployee = employeeService.getEmployeeById(id);
        oldEmployee.setName(employee.getName());
        oldEmployee.setAddress(employee.getAddress());
        oldEmployee.setEmail(employee.getEmail());
        employeeService.updateEmployee(oldEmployee);
        return "redirect:/employees";
    }
    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }


    @GetMapping("/employee/new")
        public String createEmployeeForm(Model model){
            Employee employee = new Employee();
            model.addAttribute("employee", employee);
            return "new_employee";
        }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeService.getEmployeeById(id);
        if(employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);

    }

}
