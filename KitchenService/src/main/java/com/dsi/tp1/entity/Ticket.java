package com.dsi.tp1.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="stat")
	private String stat;
	
	@Temporal(TemporalType.TIME)
	@Column(name="preparingTime")
	private int preparingTime;
	
	
	@Temporal(TemporalType.TIME)
	@Column(name="pickedUpTime")
	private int pickedUpTime;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getState() {
		return stat;
	}


	public void setState(String state) {
		this.stat = state;
	}


	public int getPreparingTime() {
		return preparingTime;
	}


	public void setPreparingTime(int preparingTime) {
		this.preparingTime = preparingTime;
	}


	public int getPickedUpTime() {
		return pickedUpTime;
	}


	public void setPickedUpTime(int pickedUpTime) {
		this.pickedUpTime = pickedUpTime;
	}


	public Ticket(int id, String state, int preparingTime, int pickedUpTime) {
		super();
		this.id = id;
		this.stat = state;
		this.preparingTime = preparingTime;
		this.pickedUpTime = pickedUpTime;
	}


	public Ticket() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
