package com.example.demo.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
//@Table(name="Absence")
public class Absence {
	@Id
	private String matricule;
	private double nbJoursAbsences;
    private List<LocalDate> JoursAbsence;
    private String AbsenceS1;
    private String AbsenceS2;
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public double getNbJoursAbsences() {
		return nbJoursAbsences;
	}
	public void setNbJoursAbsences(double nbJoursAbsences) {
		this.nbJoursAbsences = nbJoursAbsences;
	}
	public List<LocalDate> getJoursAbsence() {
		return JoursAbsence;
	}
	public void setJoursAbsence(List<LocalDate> joursAbsence) {
		JoursAbsence = joursAbsence;
	}
	public String getAbsenceS1() {
		return AbsenceS1;
	}
	public void setAbsenceS1(String absenceS1) {
		AbsenceS1 = absenceS1;
	}
	public String getAbsenceS2() {
		return AbsenceS2;
	}
	public void setAbsenceS2(String absenceS2) {
		AbsenceS2 = absenceS2;
	}
	public Absence(String matricule, List<LocalDate> joursAbsence,double nbJoursAbsences, String absenceS1, String absenceS2) {
		super();
		this.matricule = matricule;                   
		this.nbJoursAbsences = nbJoursAbsences;
		JoursAbsence = joursAbsence;
		AbsenceS1 = absenceS1;
		AbsenceS2 = absenceS2;
		// TODO Auto-generated constructor stub
	}

	
    
    
	
}
