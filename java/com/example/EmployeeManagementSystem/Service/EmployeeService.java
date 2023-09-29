package com.example.EmployeeManagementSystem.Service;

import java.util.List;

import com.example.EmployeeManagementSystem.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();
	
	void save(Employee employee);
	
	Employee getById(Long id);
	
	void deleteById(Long ids);
	
}
