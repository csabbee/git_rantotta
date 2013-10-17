package com.eggs.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.eggs.Food;
import com.eggs.Menu;
import com.eggs.MenuBuilder;
import com.eggs.MenuRepository;

public class CsvFileMenuRepository implements MenuRepository {

	private List<Menu> menus = new ArrayList<Menu>();

	public CsvFileMenuRepository(String ...restaurants) {
		for (String nextRestaurant : restaurants) {
			processSingleRestaurant(nextRestaurant);
		}
	}	

	public CsvFileMenuRepository(String restaurant) {
		processSingleRestaurant(restaurant);
	}

	private void processSingleRestaurant(String restaurant) {
		try {
			String filename = restaurant + ".csv";
			
			InputStream stream = getClass().getClassLoader().getSystemClassLoader().getResourceAsStream(filename);
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

			MenuBuilder builder = MenuBuilder.menu().restaurant(restaurant);
			String line;
			while ((line = reader.readLine()) != null) {
				processMenuLine(builder, line);
			}
			menus.add(builder.build());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void processMenuLine(MenuBuilder builder, String line) {
		String[] fields = line.split(",");
		float price = Float.parseFloat(fields[2]);
		builder.food(fields[0].trim(), fields[1].trim(),price);
	}

	public List<Menu> getAllmenu() {
		return menus;
	}

	public static void main(String[] args) {
		CsvFileMenuRepository repository = new CsvFileMenuRepository("karcsi", "marcello");
		ConsoleMenuPrinter printer = new ConsoleMenuPrinter(repository);
		
		printer.printMenus();
	}

}
