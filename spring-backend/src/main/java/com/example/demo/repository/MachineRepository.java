package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Machine;

public interface MachineRepository extends MongoRepository<Machine,String>{

}
