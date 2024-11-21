package com.dsi.tp1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.tp1.entities.Etudiant;
import com.dsi.tp1.entities.Livre;
import com.dsi.tp1.repositories.LivreRepository;

@Service
public class LivreServiceImpl implements IServiceLivre{

		@Autowired
		private LivreRepository livreRepository;
		


		@Override
		public Livre findLivre(int id) {
			// TODO Auto-generated method stub
			Optional<Livre> etudiant=livreRepository.findById(id);
			if (etudiant.isPresent()){
				return etudiant.get();
			}
			else {
				return null;
			}
		}

		@Override
		public boolean saveLivre(Livre Livre) {
			// TODO Auto-generated method stub
			if(livreRepository.save(Livre)!=null) {
				return true;
			}
			else
				return false;
		}

		@Override
		public boolean deleteLivre(int id) {
			// TODO Auto-generated method stub
			livreRepository.deleteById(id);
			return !livreRepository.existsById(id);
		}

		@Override
		public Livre updateLivre(Livre Livre, int id) {
			// TODO Auto-generated method stub
			Livre.setCode(id);
			livreRepository.save(Livre);
			return livreRepository.findById(id).get();
		}

		@Override
		public List<Livre> getAllLivre() {
			// TODO Auto-generated method stub
			return this.livreRepository.findAll();
		}

		@Override
		public List<Livre> findByTitre(String titre) {
			// TODO Auto-generated method stub
			return livreRepository.findByTitre(titre);
		}



	

}
