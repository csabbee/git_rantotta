package com.eggs.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import com.eggs.Food;
import com.eggs.Menu;
import com.eggs.MenuRepository;
import com.eggs.MenuRepositoryReader;

public class YamlFileMenuRepositoryReader implements MenuRepositoryReader {

	private List<Menu> menus = new ArrayList<Menu>();
	private static Logger logger = LoggerFactory.getLogger(YamlFileMenuRepositoryReader.class);
	
	public YamlFileMenuRepositoryReader() {
		logger.debug("In the constructor");
		File file = new File("menus.yaml");
		//Yaml
		Constructor constructor = new Constructor(Menu.class);
		TypeDescription menuDescription = new TypeDescription(Menu.class);
		menuDescription.putListPropertyType("foods", Food.class);
		constructor.addTypeDescription(menuDescription);
		Yaml yaml = new Yaml(constructor);
		//menus.add((Menu) yaml.load(getClass().getClassLoader().getResourceAsStream(file.getName())));
		Iterable<Object> iter = yaml.loadAll(getClass().getClassLoader().getResourceAsStream(file.getName()));
		for(Object o : iter){
			menus.add((Menu)o);
		}
	}

	public MenuRepository read() {
		// TODO Auto-generated method stub
		return new MenuRepository(menus);
	}
	
}
