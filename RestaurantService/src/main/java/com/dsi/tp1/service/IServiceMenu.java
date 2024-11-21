package com.dsi.tp1.service;

import java.util.List;

import com.dsi.tp1.entity.Menu;

public interface IServiceMenu {

	public List<Menu> findRestaurantMenu(String mot);
}
