package com.dsi.tp1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.tp1.entity.Courier;
import com.dsi.tp1.repository.CourierRepository;

@Service
public class CourierService {
	@Autowired
	private CourierRepository courierRepository;	
	
	public List<Courier> getAllCourier() {
		// TODO Auto-generated method stub
		return courierRepository.findAll() ;
	}

	public Optional<Courier> findCourier(int id) {
		// TODO Auto-generated method stub
		return courierRepository.findById(id);
	}

	
	public boolean deleteCourier(int id) {
		// TODO Auto-generated method stub
		courierRepository.deleteById(id);
		return courierRepository.existsById(id);
	}

	
	public Courier updateCourier(Courier t, int id) {
		// TODO Auto-generated method stub
		t.setId(id);
		courierRepository.save(t);
		return courierRepository.findById(id).get();
	}

	
	public List<Courier> Courier(Courier t) {
		// TODO Auto-generated method stub
		return (List<Courier>) courierRepository.save(t);
	}
}
