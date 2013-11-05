package com.eggs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

public class Menu {
    private Restaurant restaurant;
    
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
        publisher.publishEvent(new FoodEvent(food));
    }
}
