package com.dsi.tp1.service;

import java.util.List;

import com.dsi.tp1.entities.Etudiant;
import com.dsi.tp1.entities.Livre;

public interface IServiceLivre {

	List<Livre> getAllLivre();

	Livre findLivre(int id);

	boolean deleteLivre(int id);

	Livre updateLivre(Livre Livre, int id);

	boolean saveLivre(Livre Livre);
	List<Livre> findByTitre(String Titre); 

}
