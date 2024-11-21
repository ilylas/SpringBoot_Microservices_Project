package com.example.demo;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.example.demo.model.Retards;
import com.example.demo.repository.RetardsRepository;


@SpringBootApplication
public class SpringBackendApplication implements CommandLineRunner {

	@Autowired
	private MongoTemplate mongoTemplate;
	private RetardsRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBackendApplication.class, args);	    
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("---------------"+mongoTemplate.getCollectionNames());
        /*Retards retard = new Retards("555", 45);
        mongoTemplate.insert(retard);
    	repository.insert(retard);
    	*/
	}
	
	
}
