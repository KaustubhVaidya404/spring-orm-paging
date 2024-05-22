package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeePagingRepository;

import jakarta.servlet.http.HttpSession;


@Service
public class EmployeePagingService {

	@Autowired
	EmployeePagingRepository repo;

	public List<Employee> getNext(HttpSession session) {

		Integer page = (Integer) session.getAttribute("page");

		if (page == null) {
			page = 0;
			session.setAttribute("page", page);
		} else {
			page++;
		}

		List<Employee> list = repo.findAll(PageRequest.of(page, 3)).getContent();
		return list;
	}

	public List<Employee> getPrevious(HttpSession session) {
		Integer page = (Integer) session.getAttribute("page");

		if (page == null) {
			page = 0;
			session.setAttribute("page", page);
		} else {
			if (page != 0) {
				page--;
			}
		}
		
		List<Employee> list = repo.findAll(PageRequest.of(page, 3)).getContent();
		return list;
	}
}
