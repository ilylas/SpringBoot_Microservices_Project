package com.dsi.tp1.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="EtatLivre")
public class EtatLivre {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="code")
	private int Code;
	@Column(name="Disponible")
	private boolean Disponible;
	@Column(name="Emprunté")
	private boolean Emprunté;
	
	@OneToMany(mappedBy="etatLivre")
	private List<Livre> livre;

	public EtatLivre(boolean disponible,boolean emprunté) {
		Emprunté = emprunté;
		Disponible=disponible;
	}


	public EtatLivre() {
		super();
	}


	@Override
	public String toString() {
		return "EtatLivre [Code=" + Code + ", Disponible=" + Disponible + ", Emprunté=" + Emprunté 
				+ "]";
	}


	public void setEmprunté(boolean emprunté) {
		Emprunté = emprunté;
	}
	
	
	
	
}
