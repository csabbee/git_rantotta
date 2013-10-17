package com.eggs.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eggs.Menu;
import com.eggs.MenuBuilder;
import com.eggs.MenuRepository;

public class CsvFileMenuRepository implements MenuRepository {

	private Logger logger = LoggerFactory.getLogger(CsvFileMenuRepository.class);
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
		logger.debug("processing next restaurant: {}", restaurant);
		String filename = restaurant + ".csv";

		try {
			logger.debug("restaurant is read from file: {}", filename);
			
			InputStream stream = getClass().getClassLoader().getResourceAsStream(filename);
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

			MenuBuilder builder = MenuBuilder.menu().restaurant(restaurant);
			String line;
			while ((line = reader.readLine()) != null) {
				processMenuLine(builder, line);
			}
			menus.add(builder.build());
			
		} catch (Exception e) {
			logger.error("Menu CSV file couldn't be processed: {}", filename);
			logger.error("DETAILS", e);
		}
	}

	private void processMenuLine(MenuBuilder builder, String line) {
		logger.trace("processing line: {}", line);
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
