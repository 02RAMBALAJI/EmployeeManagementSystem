package com.example.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeManagementSystem.model.Employee;

@Repository
public interface Employeerepository extends JpaRepository<Employee, Long>{
	

}
