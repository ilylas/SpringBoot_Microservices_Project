package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface EmployeeRepositoy extends MongoRepository<Employee,String>{

	//Optional<Employee> findByMatricule(String matricule);
} 
