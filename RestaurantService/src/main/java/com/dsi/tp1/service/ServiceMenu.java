package com.dsi.tp1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.tp1.entity.Menu;
import com.dsi.tp1.repository.MenuRepository;



@Service
public class ServiceMenu implements IServiceMenu{

	@Autowired
	MenuRepository menuRepository;
	
	@Override
	public List<Menu> findRestaurantMenu(String mot) {
		return menuRepository.findBynom(mot);
	}

}
