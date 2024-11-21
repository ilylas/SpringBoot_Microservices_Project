package com.dsi.tp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.dsi.tp1.entity.Adresse;
import com.dsi.tp1.repository.AdresseRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class RestaurantServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(RestaurantServiceApplication.class, args);
	}

	@Autowired
	private AdresseRepository adresseRepository;
	
	@Override
	public void run(String... args) throws Exception { 
		// TODO Auto-generated method stub
		adresseRepository.save(new Adresse(1,"la cuisina","bardo","lacite","Ariana"));
		adresseRepository.save(new Adresse(2,"laf","bardo","lac","Arianacentre"));
	}

}
