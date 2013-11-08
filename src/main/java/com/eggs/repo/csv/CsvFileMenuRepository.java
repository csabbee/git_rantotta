package com.eggs.repo.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.eggs.domain.Menu;
import com.eggs.domain.MenuBuilder;
import com.eggs.domain.MenuEvent;
import com.eggs.interfaces.MenuRepository;

@Component
public class CsvFileMenuRepository implements MenuRepository {

    private Logger logger = LoggerFactory.getLogger(CsvFileMenuRepository.class);
    private String[] restaurantNames;
    private List<Menu> menus = new ArrayList<Menu>();
    
    @Autowired
    private ApplicationEventPublisher publisher;
    @Autowired
    private ApplicationContext ctx;

    public CsvFileMenuRepository(){
        this("karcsi", "marcello");
    }
    public CsvFileMenuRepository(String... restaurantNames) {
        this.restaurantNames = restaurantNames;
    }

    private Menu processSingleRestaurant(String restaurant) {
        logger.debug("processing next restaurant: {}", restaurant);
        String filename = restaurant + ".csv";
        logger.debug("restaurant is read from file: {}", filename);

        MenuBuilder builder = ctx.getBean(MenuBuilder.class);
        builder.restaurant(restaurant);

        Resource file = ctx.getResource(filename);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            String line = "";
            try {
                while ((line = reader.readLine()) != null) {
                    processMenuLine(builder, line);
                }
            } catch (IOException e) {
                logger.error("couldnt process LINE: " + line, e);
            }

        } catch (IOException e1) {
            logger.error("Resource Error: ", e1);
        }        

        return builder.build();
    }

    private void processMenuLine(MenuBuilder builder, String line) {
        logger.trace("processing line: {}", line);
        String[] fields = line.split(",");
        float price = Float.parseFloat(fields[2]);
        builder.food(fields[0].trim(), fields[1].trim(), price);
    }

    @PostConstruct
    public void read() {
        for (String restaurant : restaurantNames) {
            Menu menu = processSingleRestaurant(restaurant);
            addMenu(menu);
        }
    }

    public List<Menu> getAllmenu() {
        return menus;
    }
    public void addMenu(Menu menu) {
        menus.add(menu);
        publishEvent(menu);
    }
    private void publishEvent(Menu menu) {
        if (publisher!= null) {
          publisher.publishEvent(new MenuEvent(menu));
        } else {
            logger.warn("Menu is new-sed ...");
        }
    }
}
