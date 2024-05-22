package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repo;

	public void addData(Employee employee) {
		repo.save(employee);
	}
	
	public void updateData(Employee employee) {
		repo.save(employee);
	}
	
	public void deleteDate(int id) {
		Employee employee = repo.findById(id).get();
		repo.delete(employee);
	}
	
	public Employee getById(int id) {
		Employee employee = repo.findById(id).get();
		return employee;
	}
	
}
