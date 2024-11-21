package com.dsi.tp1.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Etudiant implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int code;
	
	private String nom;
	
	private String prenom;
	
	@Temporal(TemporalType.DATE)
	private LocalDate dateNaissance;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="idAdresse")
	private Adresse adresse;
	
	
	

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
		name="emprunt"
			,joinColumns={
				@JoinColumn(name="etudiant_id")		
			}
			,inverseJoinColumns={
				@JoinColumn(name="livre_id")		
			}
	)
	private List<Livre>livres_empruntés;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Etudiant(Adresse adresse) {
		super();
		this.adresse=adresse;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Livre> getLivres_empruntés() {
		return livres_empruntés;
	}

	public void setLivres_empruntés(List<Livre> livres_empruntés) {
		this.livres_empruntés = livres_empruntés;
	}

	public Etudiant(int code, String nom, String prenom, LocalDate dateNaissance, Adresse adresse,
			List<Livre> livres_empruntés) {
		super();
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.livres_empruntés = livres_empruntés;
	}

	public Etudiant() {
		super();
	}


	public Etudiant(String nom, String prenom, LocalDate dateNaissance, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
	}



	
	

	
	
	

}
