package com.eggs.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eggs.Menu;
import com.eggs.MenuBuilder;
import com.eggs.MenuRepository;
import com.eggs.MenuRepositoryReader;

public class CsvFileMenuRepositoryReader implements MenuRepositoryReader {

    private Logger logger = LoggerFactory.getLogger(CsvFileMenuRepositoryReader.class);
    private String[] restaurantNames;

    public CsvFileMenuRepositoryReader(String... restaurantNames) {
        this.restaurantNames = restaurantNames;
    }

    private Menu processSingleRestaurant(String restaurant) {
        logger.debug("processing next restaurant: {}", restaurant);
        String filename = restaurant + ".csv";
        logger.debug("restaurant is read from file: {}", filename);

        InputStream stream = getClass().getClassLoader().getResourceAsStream(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        MenuBuilder builder = MenuBuilder.menu().restaurant(restaurant);
        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                processMenuLine(builder, line);
            }
        } catch (IOException e) {
            logger.error("couldnt process LINE: " + line, e);
        }
        return builder.build();
    }

    private void processMenuLine(MenuBuilder builder, String line) {
        logger.trace("processing line: {}", line);
        String[] fields = line.split(",");
        float price = Float.parseFloat(fields[2]);
        builder.food(fields[0].trim(), fields[1].trim(), price);
    }

    public MenuRepository read() {
        List<Menu> menus = new ArrayList<Menu>();

        for (String restaurant : restaurantNames) {
            Menu menu = processSingleRestaurant(restaurant);
            menus.add(menu);
        }

        MenuRepository repo = new MenuRepository(menus);
        return repo;
    }

    public static void main(String[] args) {
        CsvFileMenuRepositoryReader reader = new CsvFileMenuRepositoryReader("karcsi", "marcello");
        ConsoleMenuPrinter printer = new ConsoleMenuPrinter(reader);

        printer.printMenus();
    }
}
