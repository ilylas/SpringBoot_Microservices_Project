package com.dsi.tp1.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="Adresse")
public class Adresse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Numéro;
	
	@Column(name = "nom")
	private String Nom;
	
	@Column(name = "rue")
	private String Rue;

	@Column(name = "cite")
	private String Cité;

	@Column(name = "ville")
	private String Ville;

	public int getNuméro() {
		return Numéro;
	}

	public void setNuméro(int numéro) {
		Numéro = numéro;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getRue() {
		return Rue;
	}

	public void setRue(String rue) {
		Rue = rue;
	}

	public String getCité() {
		return Cité;
	}

	public void setCité(String cité) {
		Cité = cité;
	}

	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	public Adresse(int numéro, String nom, String rue, String cité, String ville) {
		super();
		Numéro = numéro;
		Nom = nom;
		Rue = rue;
		Cité = cité;
		Ville = ville;
	}

	public Adresse(String nom, String rue, String cité, String ville) {
		super();
		Nom = nom;
		Rue = rue;
		Cité = cité;
		Ville = ville;
	}

	public Adresse() {
		super();
	}

	

	


}
