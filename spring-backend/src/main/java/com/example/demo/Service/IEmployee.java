package com.example.demo.Service;

import java.util.List;
import java.util.Optional;


import com.example.demo.model.Employee;

public interface IEmployee {

	public List<Employee> getAllEmployee();
	
	Optional<Employee> getEmploye(String matricule);
	
	String saveEmployee(Employee employe);
	
	// v2 String update(Employee e,String id);
	
	String deleteEmployee(String matricule);
	
	//String updateEmployee(Employee updatedEmployee,String id);
	
	// v1 Employee updateEmployee(Employee employee);
	
	
	
	
	
	
	
}
