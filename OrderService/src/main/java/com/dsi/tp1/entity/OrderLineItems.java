package com.dsi.tp1.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="OrderLineItems")
public class OrderLineItems implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "quantite")
	private int quantite;
	
	@Column(name = "idmenu")
	private int idMenu;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idOrder")
	private Ordere ordere;

	public OrderLineItems(int id, int quantite, int idMenu, Ordere ordere) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.idMenu = idMenu;
		this.ordere = ordere;
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

	public Ordere getOrdere() {
		return ordere;
	}

	public void setOrdere(Ordere ordere) {
		this.ordere = ordere;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
