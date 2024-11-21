package com.dsi.tp1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.tp1.entities.Etudiant;
import com.dsi.tp1.repositories.EtudiantRepository;

@Service
public class EtudiantServiceImpl implements IServiceEtudiant{

	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Override
	public List<Etudiant> getAllEtudiant() {
		// TODO Auto-generated method stub
		return etudiantRepository.findAll();
	}

	@Override
	public Etudiant findEtudiant(int id) {
		// TODO Auto-generated method stub
		Optional<Etudiant> etudiant=etudiantRepository.findById(id);
		if (etudiant.isPresent()){
			return etudiant.get();
		}
		else {
			return null;
		}
	}

	@Override
	public boolean saveEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		if(etudiantRepository.save(etudiant)!=null) {
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean deleteEtudiant(int id) {
		// TODO Auto-generated method stub
		etudiantRepository.deleteById(id);
		return !etudiantRepository.existsById(id);
	}

	@Override
	public Etudiant updateEtudiant(Etudiant etudiant, int id) {
		// TODO Auto-generated method stub
		etudiant.setCode(id);
		etudiantRepository.save(etudiant);
		return etudiantRepository.findById(id).get();
	}

	@Override
	public List<Etudiant> findByNom(String nom) {
		// TODO Auto-generated method stub
		return etudiantRepository.findByNom(nom);
	}


	

}
