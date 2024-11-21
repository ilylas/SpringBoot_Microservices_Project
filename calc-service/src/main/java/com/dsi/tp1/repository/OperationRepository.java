package com.dsi.tp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsi.tp1.entity.Operation;

public interface OperationRepository extends JpaRepository<Operation,Integer>{

}
