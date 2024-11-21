package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.RetardsService;
import com.example.demo.model.Employee;
import com.example.demo.model.Retards;
import com.example.demo.repository.RetardsRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class RetardsController {
	
	@Autowired
	private RetardsService Service ;
	
	@Autowired JdbcTemplate jdbctemplate;

	
	@GetMapping("/saveretards/{mois}")
    public List<Retards> saveRetardsInDB(@PathVariable String mois) throws NumberFormatException, IOException {
         return Service.saveRetardsInDB(mois);
    }

}
