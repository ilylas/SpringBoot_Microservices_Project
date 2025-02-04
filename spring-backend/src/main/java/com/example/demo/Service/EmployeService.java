package com.example.demo.Service;


//import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepositoy;

import jakarta.transaction.Transactional;

@Service
public class EmployeService implements IEmployee{
	
	@Autowired
	private EmployeeRepositoy repository;
	

	@GetMapping("/findAllEmployes")
	public List<Employee> getEmployes(){
		return repository.findAll();
	}
	
	@GetMapping("/findAllEmploye/{id}")
	public Optional<Employee> getEmploye(String matricule){
		return repository.findById(matricule);
	}
	
	@DeleteMapping("/deleteEmploye/{id}")
	public String deleteEmployee(String matricule) {
		repository.deleteById(matricule);
		return "Employe deleted with id : "+ matricule;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	
	@PostMapping("/addEmploye")
	public String saveEmployee(Employee employe) {
		repository.save(employe);
		return "Added Employe with matricule : " + employe.getMatricule();
	}

	




}

