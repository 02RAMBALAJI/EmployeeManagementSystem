package com.example.EmployeeManagementSystem.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.repository.Employeerepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private Employeerepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        if(Objects.nonNull(employee)){
            employeeRepository.save(employee);
        }
    }

    @Override
    public Employee getById(Long id) {
        Employee employee = null;
        if (Objects.nonNull(id)) {
            Optional<Employee> optionalEmployee = employeeRepository.findById(id);
            if(optionalEmployee.isPresent()){
                employee = optionalEmployee.get();
            }else{
                throw new RuntimeException("Employee not found with the id:"+ id);
            }
        }
        return employee;
    }

    @Override
    public void deleteById(Long id) {
        if(Objects.nonNull(id)){
            employeeRepository.deleteById(id);
        }
    }
}




//@Service
//public class EmployeeServiceImpl implements EmployeeService{
//
//	@Autowired
//	private Employeerepository employeeRepository;	
//	
//	@Override
//	public List<Employee> getAllEmployee() {
//		
//		return employeeRepository.findAll();
//	}
//
//	@Override
//	public void save(Employee employee) {
//		if(Objects.nonNull(employee)) {
//			employeeRepository.save(employee);
//		}
//		
//	}
//
//	@Override
//	public Employee getById(Long id) {
//		Employee employee=null;
//		if(Objects.nonNull(id)) 
//		{
//			Optional<Employee> optionalEmployee = employeeRepository.findById(id);
//			if(optionalEmployee.isPresent()) {
//				employee = optionalEmployee.get();
//			}
//			else {
//				throw new RuntimeException("Employee not found wth the id:"+ id);
//			}
//		}
//		return employee;
//	}
//
//	@Override
//	public void deleteById(Long id) {
//		if(Objects.nonNull(id)) {
//			employeeRepository.deleteById(id);
//		}
//	}	
//}
