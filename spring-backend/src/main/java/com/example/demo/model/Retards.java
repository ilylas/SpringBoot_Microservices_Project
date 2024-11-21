package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Data
//@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name="Retard")
public class Retards {
	@Id
	private String matricule;
	private int nbHeuresRetards;
    private int total;
    private int totalS2;
	
	public int getTotal_1() {
		return total;
	}
	public void setTotal_1(int total_1) {
		this.total = total_1;
	}
	public int getTotalS2_1() {
		return totalS2;
	}
	public void setTotalS2_1(int totalS2) {
		this.totalS2 = totalS2;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public int getNbHeuresRetards() {
		return nbHeuresRetards;
	}
	public void setNbHeuresRetards(int nbHeuresRetards) {
		this.nbHeuresRetards = nbHeuresRetards;
	}
	/*
	public Retards() {
		super();
		// TODO Auto-generated constructor stub
	}
	*/
	public Retards( String matricule_1, int nbHeuresRetards_1, int total_1, int totalS2_1) {
		super();
		this.matricule = matricule_1;
		this.nbHeuresRetards = nbHeuresRetards_1;
		this.total = total_1;
		this.totalS2 = totalS2_1;
	}
	
	
	/*
    private Employee employee;

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
*/
}
