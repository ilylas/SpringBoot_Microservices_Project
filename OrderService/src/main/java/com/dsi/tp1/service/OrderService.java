package com.dsi.tp1.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.dsi.tp1.entity.Ordere;
import com.dsi.tp1.repository.OrdreRepository;

@Service
public class OrderService {

	@Autowired
	public OrdreRepository ordreRepository;
	
	
	public List<Ordere> getAllOrdres() {
		// TODO Auto-generated method stub
		return ordreRepository.findAll() ;
	}

	public Optional<Ordere> findOrdre(int id) {
		// TODO Auto-generated method stub
		return ordreRepository.findById(id);
	}

	
	public boolean deleteOrdre(int id) {
		// TODO Auto-generated method stub
		ordreRepository.deleteById(id);
		return ordreRepository.existsById(id);
	}

	
	public Ordere updateOrdre(Ordere o, int id) {
		// TODO Auto-generated method stub
		o.setId(id);
		ordreRepository.save(o);
		return ordreRepository.findById(id).get();
	}

	
	public List<Ordere> saveOrdre(Ordere o) {
		// TODO Auto-generated method stub
		return (List<Ordere>) ordreRepository.save(o);
	}

}
