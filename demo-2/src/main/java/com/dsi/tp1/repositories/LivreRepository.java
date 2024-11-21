package com.dsi.tp1.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsi.tp1.entities.Livre;



public interface LivreRepository extends JpaRepository<Livre,Integer>{
	
	public List<Livre> findByTitre(String Titre); 


}
