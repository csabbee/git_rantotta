package com.eggs.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Menu {
    private Restaurant restaurant;
    private static final Logger logger = LoggerFactory.getLogger(Menu.class);
    
    @Autowired
    private ApplicationEventPublisher publisher;
    
    private Map<String, Food> foodMap = new HashMap<String, Food>();

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Food> getFoodList() {
        ArrayList list = new ArrayList(foodMap.values());
        return list;
    }

    public void setFoodList(List<Food> foodList) {
        for (Food food : foodList) {
            addFood(food);
        }
    }

    public void setFoodMap(Map<String, Food> foodMap) {
        this.foodMap = foodMap;
    }

    public void addFood(Food food) {
        foodMap.put(food.getId(), food);
        publishEvent(food);
    }

    private void publishEvent(Food food) {
        if (publisher!= null) {
          publisher.publishEvent(new FoodEvent(food));
        } else {
            logger.warn("Menu is new-sed ...");
        }
    }
}
