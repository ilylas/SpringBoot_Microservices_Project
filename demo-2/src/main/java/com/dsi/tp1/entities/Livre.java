package com.dsi.tp1.entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="livre_biblio")
public class Livre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="code")
	private int Code;
	@Column(name="isbn")
	private String ISBN;
	@Column(name="titre_livre")
	private String titre;
	@Column(length=40,name="auteur_livre")
	private String Auteur;
	@Temporal(TemporalType.DATE)
	@Column(name="date_de_publication")
	private Date Date_de_publication;
	@Column(name="nb_copies")
	private int NombreDeCopies;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idEtat")
	private EtatLivre etatLivre;
	
	public int getCode() {
		return Code;
	}
	public void setCode(int code) {
		Code = code;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return Auteur;
	}
	public void setAuteur(String auteur) {
			Auteur = auteur;
			System.out.println("donner une valeur correcte !");
		
	}
	public Date getDate_de_publication() {
		return Date_de_publication;
	}
	public void setDate_de_publication(Date date_de_publication) {
		Date_de_publication = date_de_publication;
	}
	public int getNb_copies() {
		return NombreDeCopies;
	}
	public void setNb_copies(int nb_copies) {
		this.NombreDeCopies = nb_copies;
	}
	public Livre(String iSBN,EtatLivre etatLivre) {
		super();
		ISBN = iSBN;
		this.etatLivre = etatLivre;
	}
	public Livre() {
		super();
	}
	
	@Override
	public String toString() {
		return "Livre [Code=" + Code + ", ISBN=" + ISBN + ", Titre=" + titre + ", Auteur=" + Auteur
				+ ", Date_de_publication=" + Date_de_publication + ", NombreDeCopies=" + NombreDeCopies + ", etatLivre="
				+ etatLivre + "]";
	}
	public EtatLivre getEtatLivre() {
		return etatLivre;
	}
	public void setEtatLivre(EtatLivre etatLivre) {
		this.etatLivre = etatLivre;
	}
	
	public void emprunter() {
		this.etatLivre=new EtatLivre(false,true);
	}
	
	
	
}
