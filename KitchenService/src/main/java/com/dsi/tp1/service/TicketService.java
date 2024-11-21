package com.dsi.tp1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.tp1.entity.Ticket;
import com.dsi.tp1.repository.TiketRepository;



@Service
public class TicketService {
	@Autowired
	private TiketRepository tiketRepository;	
	
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		return tiketRepository.findAll() ;
	}

	public Optional<Ticket> findTicket(int id) {
		// TODO Auto-generated method stub
		return tiketRepository.findById(id);
	}

	
	public boolean deleteTicket(int id) {
		// TODO Auto-generated method stub
		tiketRepository.deleteById(id);
		return tiketRepository.existsById(id);
	}

	
	public Ticket updateTicket(Ticket t, int id) {
		// TODO Auto-generated method stub
		t.setId(id);
		tiketRepository.save(t);
		return tiketRepository.findById(id).get();
	}

	
	public List<Ticket> saveTicket(Ticket t) {
		// TODO Auto-generated method stub
		return (List<Ticket>) tiketRepository.save(t);
	}
}
