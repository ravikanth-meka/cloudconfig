package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entities.Department;
import com.example.demo.repo.DepartmentRepository;

@RestController
@RequestMapping("department")
public class DepartmentController {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@GetMapping
	public Department getDepartmentDetails(@RequestParam(value = "deptNo") int deptNo) {

		Department dept = departmentRepository.findByDeptNo(deptNo);
		// return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		if (dept == null) {
			// https://www.baeldung.com/exception-handling-for-rest-with-spring  
			// Spring 5 introduced the ResponseStatusException class.                     ****************IMPORTANT
			// We can create an instance of it providing an HttpStatus and optionally a
			// reason and a cause:
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department Not Found");
		}
		return dept;
		
	}
	
	
	@GetMapping("/alldepts")
	public List<Department> getAllDepartmentDetails() {
		List<Department> depts = departmentRepository.findAll();
		return depts;
	}

}
