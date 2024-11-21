package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.Machine;
import com.example.demo.repository.MachineRepository;

@RestController
@RequestMapping("api/v2/")
public class MachineController {
	@Autowired
	private MachineRepository repository2;
	
	@PostMapping("/addMachine")
	public String saveEmployee(@RequestBody Machine machine) {
		repository2.save(machine);
		return "Added Employe with id : " + machine.getId();
	}
	
	@GetMapping("/findAllMachines")
	public List<Machine> getMachines(){
		return repository2.findAll();
	}
	
	@GetMapping("/findAllMachine/{matricule}")
	public Optional<Machine> getMachine(@PathVariable String id){
		return repository2.findById(id);
	}
	
	@DeleteMapping("/deleteEmploye/{matricule}")
	public String deleteEmployee(@PathVariable String id) {
		repository2.deleteById(id);
		return "Employe deleted with id : "+ id;
	}
}
