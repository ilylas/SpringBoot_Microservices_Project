package com.dsi.tp1.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="lineItems")
public class LineItems implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name="quantite")
	private int quantite;
	
	@Column(name="idMenu")
	private int idMenu;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idTicket")
	private Ticket ticket;

	public LineItems(int id, int quantite, int idMenu, Ticket idTicket) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.idMenu = idMenu;
		this.ticket = idTicket;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public Ticket getIdTicket() {
		return ticket;
	}

	public void setIdTicket(Ticket idTicket) {
		this.ticket = idTicket;
	}

	public LineItems() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
