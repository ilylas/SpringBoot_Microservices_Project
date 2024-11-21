package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;



import org.springframework.data.annotation.Id;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity
//@Table(name = "Employees")



@ToString
@Getter
@Setter

@Data
//@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Employees")

public class Employee {
	/*
	public Employee(String matricule) {
		super();
		Matricule = matricule;
	}
	*/

	@Id
	private String id;
	private String Matricule; 
	private String nom;
	private String prenom;
	
	public String getId() {
		return id;
	}
	
	public String getMatricule() {
		return Matricule;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setMatricule(String matricule) {
		this.Matricule = matricule;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	
	
}
