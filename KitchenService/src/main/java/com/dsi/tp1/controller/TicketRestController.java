package com.dsi.tp1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsi.tp1.entity.Ticket;
import com.dsi.tp1.service.TicketService;



@RestController
public class TicketRestController {

	@Autowired
	private TicketService ticketService;
	
	@GetMapping("/tickets")
	public List<Ticket> getAll(){
		return ticketService.getAllTickets();
	}
	
	@GetMapping("/tickets/{id}")
	public Optional<Ticket> getOne(@PathVariable("id") int id){
		return ticketService.findTicket(id);
	}
	
	
	@PostMapping("/tickets")
	public List<Ticket> addOrder(@RequestBody Ticket o) {
		return ticketService.saveTicket(o);
	}
	
	@PutMapping("/tickets/{id}")
	public Ticket updateOrder(@RequestBody Ticket o,@PathVariable("id") int id) {
		return ticketService.updateTicket(o, id);
	}
	
	@DeleteMapping("/tickets/{id}")
	public boolean deleteOne(@PathVariable("id") int id){
		return ticketService.deleteTicket(id);
	}
}
