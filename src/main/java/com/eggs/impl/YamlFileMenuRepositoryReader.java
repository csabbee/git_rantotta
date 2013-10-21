package com.eggs.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eggs.App;
import com.eggs.Menu;
import com.eggs.MenuRepository;
import com.eggs.MenuRepositoryReader;

public class YamlFileMenuRepositoryReader implements MenuRepositoryReader {

	private List<Menu> menus = new ArrayList<Menu>();
	private static Logger logger = LoggerFactory.getLogger(App.class);
	
	public YamlFileMenuRepositoryReader(List<Menu> menus) {
		
	}

	public MenuRepository read() {
		// TODO Auto-generated method stub
		return new MenuRepository(menus);
	}
	
}
