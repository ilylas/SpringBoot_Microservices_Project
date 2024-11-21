package com.dsi.tp1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="Operation")
public class Operation {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="operande1")
	private int operande1;
	
	@Column(name="operande2")
	private int operande2;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Date")
	private String Date;
	
	@Column(name="resultat")
	private int resultat;

	public Operation(String type, int operande1, int operande2, String date, int resultat) {
		super();
		this.type = type;
		this.operande1 = operande1;
		this.operande2 = operande2;
		Date = date;
		this.resultat = resultat;
	}

	public Operation() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getOperande1() {
		return operande1;
	}

	public void setOperande1(int operande1) {
		this.operande1 = operande1;
	}

	public int getOperande2() {
		return operande2;
	}

	public void setOperande2(int operande2) {
		this.operande2 = operande2;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public int getResultat() {
		return resultat;
	}

	public void setResultat(int resultat) {
		this.resultat = resultat;
	} 
	
	

}
