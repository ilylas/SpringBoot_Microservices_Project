package com.dsi.tp1.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsi.tp1.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer>{

	public List<Etudiant> findByNom(String nom); 
}
