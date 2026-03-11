package com.S.B.Project.springbootrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.S.B.Project.springbootrestapi.entity.Employee;
import com.S.B.Project.springbootrestapi.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository eRepo;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return eRepo.findAll();
	}
	
	@PostMapping("/employees")
	public Employee saveEmployeeDetails(@RequestBody Employee employee) {
		return eRepo.save(employee);
	}
	
	@GetMapping("/employees/{id}")
	public Employee getSingleEmployee(@PathVariable Long id) {
		return eRepo.findById(id).get();
	}
	
	@PutMapping("/employees")
	public Employee updateEmployeeDetails(@RequestBody Employee employee) {
		return eRepo.save(employee);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable Long id) {
		eRepo.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		
	}

}
