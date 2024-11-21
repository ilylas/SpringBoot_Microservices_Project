package com.example.demo.model;



//@Table(name = "employee")
public class Employee {
	private long id;
	private String nom;
	private String prenom;
	
	public Employee(long id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public long getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	
	
}
