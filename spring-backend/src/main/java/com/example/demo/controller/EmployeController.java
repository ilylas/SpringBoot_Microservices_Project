package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Service.EmployeService;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepositoy;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/")
public class EmployeController {
	@Autowired
	private EmployeService Service ;
	@Autowired
	private EmployeeRepositoy repository;
	
	@PostMapping("/addEmploye")
	public String saveEmployee(@RequestBody Employee employe) {
		return Service.saveEmployee(employe);
	}
	
	@GetMapping("/findAllEmployes")
	public List<Employee> getAllEmployes(){
		return Service.getAllEmployee();
	}
	
	@GetMapping("/findAllEmploye/{id}")
	public Optional<Employee> getEmploye(@PathVariable String id){
		return Service.getEmploye(id);
	}
	
	@DeleteMapping("/deleteEmploye/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable String id) throws AttributeNotFoundException{
		Employee employee = repository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("Employee not exist with id :" + id));
		
		repository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	/* v2
	@DeleteMapping("/deleteEmploye/{matricule}")
	public String deleteEmployee(@PathVariable String matricule) {
		return Service.deleteEmployee(matricule);
	}
	*/
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee employeeDetails) throws AttributeNotFoundException{
		Employee employee = repository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("Employee not exist with id :" + id));
		
		employee.setNom(employeeDetails.getNom());
		employee.setPrenom(employeeDetails.getPrenom());
		employee.setMatricule(employeeDetails.getMatricule());
		
		Employee updatedEmployee = repository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
