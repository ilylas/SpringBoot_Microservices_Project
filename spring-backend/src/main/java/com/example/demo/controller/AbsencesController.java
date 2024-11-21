package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.AbsencesService;
import com.example.demo.model.Absence;
import com.example.demo.model.Retards;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class AbsencesController {
	@Autowired
	private AbsencesService Service ;
	
	@GetMapping("/saveabsences/{mois}")
	public List<Absence> afficher(@PathVariable String mois) throws NumberFormatException, IOException{
		/*
	    Scanner sc = new Scanner(System.in);
	    String mois;
	    
	    System.out.println("Introduire le mois en question (ex: Octobre, Novembre, Decembre) ou tapez 'quitter' pour sortir:");
	    mois = sc.nextLine();
		Service.calculernbJoursAbsences(mois);
		*/
		return Service.calculernbJoursAbsences(mois);
		
	}
	
	
	
}
