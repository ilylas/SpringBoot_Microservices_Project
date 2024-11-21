package com.dsi.tp1.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Adresse")
public class Adresse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="code")
	private int Code;
	@Column(name="isbn")
	private String NumAppart;
	@Column(length=50)
	private String Rue;
	@Column(length=30)
	private String Ville;
	@Column(length=4)
	private String Code_postal;
	
	@OneToOne(mappedBy="adresse")
	private Etudiant etudiant;

	public Adresse(String numAppart, String rue, String ville, String code_postal) {
		super();
		NumAppart = numAppart;
		Rue = rue;
		Ville = ville;
		Code_postal = code_postal;
		
	}

	public Adresse() {
		super();
	}

	@Override
	public String toString() {
		return "Adresse [Code=" + Code + ", NumAppart=" + NumAppart + ", Rue=" + Rue + ", Ville=" + Ville
				+ ", Code_postal=" + Code_postal + ", etudiant=" + etudiant + "]";
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
