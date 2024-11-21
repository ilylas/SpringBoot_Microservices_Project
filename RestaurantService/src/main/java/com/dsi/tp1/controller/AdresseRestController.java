package com.dsi.tp1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsi.tp1.entity.Adresse;
import com.dsi.tp1.service.AdresseService;

@RequestMapping("/restaurant") 
@RestController
public class AdresseRestController {

	@Autowired
	private AdresseService adresseService;
	
    @Autowired
    private Environment environment;
	
    @GetMapping("/adresse")
	public List<Adresse> getAll(){
		return adresseService.getAllAdresse();
	}
	
	@GetMapping("/adresse/{id}")
	public Optional<Adresse> getOne(@PathVariable("id") int id){
		return adresseService.findAdresse(id);
	}
	
	
	@PostMapping
	public List<Adresse> addAdresse(@RequestBody Adresse o) {
		return adresseService.addAdresse(o);
	}
	
	@PutMapping("/adresse/{id}")
	public Adresse updateAdresse(@RequestBody Adresse o,@PathVariable("id") int id) {
		return adresseService.updateAdresse(o, id);
	}
	
	@DeleteMapping("/adresse/{id}")
	public boolean deleteOne(@PathVariable("id") int id){
		return adresseService.deleteAdresse(id);
	}
	
    @GetMapping("/test")
    public String test() {
        String port = environment.getProperty("local.server.port");
        return "test with port " + port;
    }
}
