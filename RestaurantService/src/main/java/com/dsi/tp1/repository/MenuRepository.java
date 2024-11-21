package com.dsi.tp1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsi.tp1.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu,Integer>{
	List<Menu> findBynom(String Nom_du_menu);
}
