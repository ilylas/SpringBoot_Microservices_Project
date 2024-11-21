package com.dsi.tp1; 

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.dsi.tp1.entities.Adresse;
import com.dsi.tp1.entities.EtatLivre;
import com.dsi.tp1.entities.Etudiant;
import com.dsi.tp1.entities.Livre;
import com.dsi.tp1.repositories.EtudiantRepository;
import com.dsi.tp1.repositories.LivreRepository;
import com.dsi.tp1.service.IServiceLivre;
import com.dsi.tp1.service.LivreServiceImpl;

@SpringBootApplication
public class Demo2Application implements CommandLineRunner{
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private LivreRepository livreRepository;

	
	//private LivreServiceImpl livreServiceImpl;
	 private  IServiceLivre livreServiceImpl;
	
	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		etudiantRepository.save(new Etudiant("etudiant1","etudiant1",LocalDate.of(2000,2,15),new Adresse("fdg","nah el matar","Soukra","2036")));
		etudiantRepository.save(new Etudiant("etudiant2","etudiant2",LocalDate.of(2001,11,15),new Adresse("fdg","ba7tha el monoprix","Aouina","2036")));
		List<Etudiant> lesetudiants = etudiantRepository.findAll();
		for (int i=0;i<lesetudiants.size();i++) {
			System.out.println("L'adresse de l'édudiant"+i+"a l'adresse"+lesetudiants.get(i).getAdresse().toString());
		}
		/*
		 * 1ére methode
		EtatlivreRepository.save(new EtatLivre(true,true));
		EtatlivreRepository.save(new EtatLivre(true,false));
		*/
		
		//2éme méthode
		livreRepository.save(new Livre("75",new EtatLivre(true,true)));
		livreRepository.save(new Livre("45",new EtatLivre(true,true)));
		livreRepository.save(new Livre("40",new EtatLivre(true,false)));
		
		List <Livre> leslivres=livreRepository.findAll();
		
		leslivres.forEach(livre->{
			System.out.println(livre.toString());
		});
		
		Etudiant firststudent=lesetudiants.get(0);
		leslivres.get(2).getEtatLivre().setEmprunté(true);
		firststudent.setLivres_empruntés(Arrays.asList(leslivres.get(0),leslivres.get(2)));
		
		etudiantRepository.save(firststudent);
		
		/* version1
		lesetudiants.forEach(etudiant->{
			if(etudiant.getCode()==1) {
				System.out.println("Les livres empruntés par l'étudiant 1 sont : "+etudiant.getLivres_empruntés());
			}
		});
		*/
		//version 2
		//Optional<Etudiant> et1=etudiantRepository.findById(1);
		//System.out.println(et1);
		System.out.println("Les livres empruntés par l'étudiant 1 sont : "+firststudent.getLivres_empruntés());
	
		if ( livreServiceImpl != null ) {
			List <Livre> leslivres2=livreServiceImpl.getAllLivre();
			leslivres2.forEach(livre->{
				System.out.println(livre.toString());
			});
		}

		
		
	
	}

	
	

}
