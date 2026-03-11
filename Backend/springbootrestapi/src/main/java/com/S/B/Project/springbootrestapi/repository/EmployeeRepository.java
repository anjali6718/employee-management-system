package com.S.B.Project.springbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.S.B.Project.springbootrestapi.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	

}
