package com.dsi.tp1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dsi.tp1.entity.Ordere;
import com.dsi.tp1.service.OrderService;

@RestController
public class OrderRestController{
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/Ordres")
	public List<Ordere> getAll(){
		return orderService.getAllOrdres();
	}
	
	@GetMapping("/Ordres/{id}")
	public Optional<Ordere> createOrder(@RequestParam("id") int id){
		return orderService.findOrdre(id);
	}
	
	
	@PostMapping("/Ordres")
	public List<Ordere> addOrdere(@RequestBody Ordere o) {
		return orderService.saveOrdre(o);
	}
	
	@PutMapping("/Ordres/{id}")
	public Ordere updateEtudiant(@RequestBody Ordere o,@PathVariable("id") int id) {
		return orderService.updateOrdre(o, id);
	}
	
	@DeleteMapping("/Ordres/{id}")
	public boolean cancelOrder(@PathVariable("id") int id){
		return orderService.deleteOrdre(id);
	}
	
	@GetMapping("/test")
	public String test() {
	    return "test with port :" + environment.getProperty("server.port");
	}

}
