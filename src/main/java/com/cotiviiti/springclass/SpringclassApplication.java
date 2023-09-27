package com.cotiviiti.springclass;

import com.cotiviiti.springclass.entity.Employee;
import com.cotiviiti.springclass.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringclassApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(SpringclassApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee e1 = new Employee("srijan","manbhawan","kcsrijan33@gmail.com");
		Employee e2 = new Employee("Ram","boudha","ram33@gmail.com");
		Employee e3 = new Employee("Shyam","Pokhara","shyam@gmail.com");
		Employee e4 = new Employee("Hari","Dailekh","hari3@gmail.com");

		employeeService.saveEmployee(e1);
		employeeService.saveEmployee(e2);
		employeeService.saveEmployee(e3);
		employeeService.saveEmployee(e4);

	}
}
