package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping("/getbyid")
	public Employee getById(@RequestParam("id") int id) {
		return service.getById(id);
	}
	
	

	@PostMapping("/add")
	public String add(@RequestParam("name") String name, @RequestParam("department") String department,
			@RequestParam("post") String post, @RequestParam("salary") int salary) {
		
		Employee employee = new Employee();
		employee.setName(name);
		employee.setDepartment(department);
		employee.setPost(post);
		employee.setSalary(salary);
		service.addData(employee);
		
		return "Data Saved";
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		
		service.deleteDate(id);
		
		return "Record deleted";
	}
	
}
