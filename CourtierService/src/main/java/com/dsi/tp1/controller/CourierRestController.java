package com.dsi.tp1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dsi.tp1.entity.Courier;
import com.dsi.tp1.service.CourierService;



@RestController
public class CourierRestController {

	@Autowired
	private CourierService courierService;
	
	@GetMapping("/Courier")
	public List<Courier> getAll(){
		return courierService.getAllCourier();
	}
	
	@GetMapping("/Courier/{id}")
	public Optional<Courier> getOne(@PathVariable("id") int id){
		return courierService.findCourier(id);
	}
	
	
	@PostMapping("/Courier")
	public List<Courier> addOrder(@RequestBody Courier o) {
		return courierService.Courier(o);
	}
	
	@PutMapping("/Courier/{id}")
	public Courier updateOrder(@RequestBody Courier o,@PathVariable("id") int id) {
		return courierService.updateCourier(o, id);
	}
	
	@DeleteMapping("/Courier/{id}")
	public boolean deleteOne(@PathVariable("id") int id){
		return courierService.deleteCourier(id);
	}
}
