package com.dsi.tp1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dsi.tp1.entities.Etudiant;
import com.dsi.tp1.service.IServiceEtudiant;

@RestController
public class EtudiantRestController {
	

	@Autowired
	IServiceEtudiant iServiceEtudiant;
	
	@GetMapping("/etudiants")
	public List<Etudiant> getAll(){
		return iServiceEtudiant.getAllEtudiant();
	}
	
	@GetMapping("/etudiants/{id}")
	public Etudiant getOne(@PathVariable("id") int id){
		return iServiceEtudiant.findEtudiant(id);
	}

	@GetMapping("/etudiantsByLastName")
	public List<Etudiant> getOneParam(@RequestParam("nom") String nom){
		return iServiceEtudiant.findByNom(nom);
	}
	
	@PostMapping("/etudiants")
	public boolean addEtudiant(@RequestBody Etudiant etudiant) {
		return iServiceEtudiant.saveEtudiant(etudiant);
	}
	
	@PutMapping("/etudiants/{id}")
	public Etudiant updateEtudiant(@RequestBody Etudiant etudiant,@PathVariable("id") int id) {
		return iServiceEtudiant.updateEtudiant(etudiant, id);
	}
	
	@DeleteMapping("/etudiants/{id}")
	public boolean deleteOne(@PathVariable("id") int id){
		return iServiceEtudiant.deleteEtudiant(id);
	}
	
}
