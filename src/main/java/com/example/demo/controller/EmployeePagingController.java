package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeePagingService;

import jakarta.servlet.http.HttpSession;

@RestController
public class EmployeePagingController {

	@Autowired
	EmployeePagingService service;
	
	@GetMapping("/getnextpage")
	public List<Employee> getNextPage(HttpSession session) {
		List<Employee> list = service.getNext(session);
		return list;
	}
	
	@GetMapping("/getprevpage")
	public List<Employee> getPreviousPage(HttpSession session){
		List<Employee> list = service.getPrevious(session);
		return list;
	}
	
}
