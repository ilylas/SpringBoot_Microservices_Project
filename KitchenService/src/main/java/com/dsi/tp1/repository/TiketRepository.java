package com.dsi.tp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsi.tp1.entity.Ticket;

public interface TiketRepository extends JpaRepository<Ticket,Integer>{

}
