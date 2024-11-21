package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection="MachineDecembre")
public class Machine {
	@Id
	private String Id;
	private String Date_Temps;
	private String Matricule;
	private String MACHINE;
	private String E_S;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getDate_Temps() {
		return Date_Temps;
	}
	public void setDate_Temps(String date_Temps) {
		Date_Temps = date_Temps;
	}
	public String getMatricule() {
		return Matricule;
	}
	public void setMatricule(String matricule) {
		this.Matricule = matricule;
	}
	public String getNumMachine() {
		return MACHINE;
	}
	public void setNumMachine(String numMachine) {
		this.MACHINE = numMachine;
	}
	public String getES() {
		return E_S;
	}
	public void setES(String eS) {
		E_S = eS;
	}
	
	
	
	
	
	
	
	
	
	
	
}

















