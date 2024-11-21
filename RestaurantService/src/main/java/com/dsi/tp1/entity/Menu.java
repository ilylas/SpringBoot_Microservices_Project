package com.dsi.tp1.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="Menu")
public class Menu implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String nom;
	
	private String Prix_du_menu;

	public Menu(int id, String nom_du_menu, String prix_du_menu) {
		super();
		this.id = id;
		nom = nom_du_menu;
		Prix_du_menu = prix_du_menu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_du_menu() {
		return nom;
	}

	public void setNom_du_menu(String nom_du_menu) {
		nom = nom_du_menu;
	}

	public String getPrix_du_menu() {
		return Prix_du_menu;
	}

	public void setPrix_du_menu(String prix_du_menu) {
		Prix_du_menu = prix_du_menu;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
