package com.eggs.impl;

import java.io.InputStream;

import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import com.eggs.Food;
import com.eggs.Menu;
import com.eggs.MenuRepository;
import com.eggs.MenuRepositoryReader;

public class YamlFileMenuRepositoryReader implements MenuRepositoryReader {

	private String yamlFileName;
	
	public YamlFileMenuRepositoryReader(String yamlFileName) {
		this.yamlFileName = yamlFileName;
	}
	
	public MenuRepository read() {
		Constructor constructor = new Constructor(MenuRepository.class);
		TypeDescription menuRepoDescription = new TypeDescription(MenuRepository.class);
		menuRepoDescription.putListPropertyType("menus", Menu.class);
		
		TypeDescription menuDescription = new TypeDescription(Menu.class);
		menuDescription.putListPropertyType("foods", Food.class);

		constructor.addTypeDescription(menuRepoDescription);
		constructor.addTypeDescription(menuDescription);
		Yaml yaml = new Yaml(constructor);
		
		InputStream stream = getClass().getClassLoader().getResourceAsStream(yamlFileName);

		MenuRepository menuRepo = (MenuRepository) yaml.load(stream);
		
		return menuRepo;
	}

	public static void main(String[] args) {
		YamlFileMenuRepositoryReader reader = new YamlFileMenuRepositoryReader("menus.yml");
		ConsoleMenuPrinter printer = new ConsoleMenuPrinter(reader.read());
		
		printer.printMenus();
	}
}
