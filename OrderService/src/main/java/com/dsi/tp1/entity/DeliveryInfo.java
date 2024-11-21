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
import jakarta.persistence.OneToOne;

import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="DeliveryInfo")
public class DeliveryInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "deliverytime")
	@Temporal(TemporalType.TIME)
	private int deliveryTime;
	
	@Column(name = "deliveryadress")
	private String deliveryAdress;
	
	@OneToOne(cascade = { CascadeType.ALL})
	@JoinColumn(name="idOrder")
	private Ordere ordere;

	public DeliveryInfo(int deliveryTime, String deliveryAdress) {
		super();
		this.deliveryTime = deliveryTime;
		this.deliveryAdress = deliveryAdress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getDeliveryAdress() {
		return deliveryAdress;
	}

	public void setDeliveryAdress(String deliveryAdress) {
		this.deliveryAdress = deliveryAdress;
	}

	public DeliveryInfo() {
		super();
	}

	

	
	

}
