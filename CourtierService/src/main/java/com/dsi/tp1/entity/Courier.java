package com.dsi.tp1.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="Courier")
public class Courier implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String nom;
	
	private int tel;
	
	private boolean Disponible;

	public Courier(int id, String nom, int tel, boolean disponible) {
		super();
		this.id = id;
		this.nom = nom;
		this.tel = tel;
		Disponible = disponible;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public boolean isDisponible() {
		return Disponible;
	}

	public void setDisponible(boolean disponible) {
		Disponible = disponible;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
