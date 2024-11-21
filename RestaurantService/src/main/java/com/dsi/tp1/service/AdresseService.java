package com.dsi.tp1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.tp1.entity.Adresse;
import com.dsi.tp1.repository.AdresseRepository;

@Service
public class AdresseService {
	@Autowired
	private AdresseRepository adresseRepository;	
	
	public List<Adresse> getAllAdresse() {
		// TODO Auto-generated method stub
		return adresseRepository.findAll() ;
	}

	public Optional<Adresse> findAdresse(int id) {
		// TODO Auto-generated method stub
		return adresseRepository.findById(id);
	}

	
	public boolean deleteAdresse(int id) {
		// TODO Auto-generated method stub
		adresseRepository.deleteById(id);
		return adresseRepository.existsById(id);
	}

	
	public Adresse Adresse(Adresse t, int id) {
		// TODO Auto-generated method stub
		t.setNuméro(id);
		adresseRepository.save(t);
		return adresseRepository.findById(id).get();
	}

	public Adresse updateAdresse(Adresse t, int id) {
		// TODO Auto-generated method stub
		t.setNuméro(id);
		adresseRepository.save(t);
		return adresseRepository.findById(id).get();
	}

	
	@SuppressWarnings("unchecked")
	public List<com.dsi.tp1.entity.Adresse> addAdresse(Adresse t) {
		// TODO Auto-generated method stub
		return (List<com.dsi.tp1.entity.Adresse>) adresseRepository.save(t);
	}
}
