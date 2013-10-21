package com.eggs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Menu {
	private static Logger logger = LoggerFactory.getLogger(Menu.class);
	private Restaurant restaurant;
	private Map<String, Food> foodMap = new HashMap<String, Food>();
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		logger.info("In setRestaurant");
		logger.debug(restaurant.toString());
		this.restaurant = restaurant;
	}
	public List<Food> getFoodList() {
		ArrayList list = new ArrayList(foodMap.values());
		return list;
	}
	public void setFoods(List<Food> foods){
		logger.info("In setFoods");
		logger.debug("The foods are: "+foods.toString());
		for(Food f : foods)
			addFood(f);
	}
	public void setFoodMap(Map<String, Food> foodMap) {
		this.foodMap = foodMap;
	}
	public void addFood(Food food) {
		foodMap.put(food.getId(), food);
		
	}
}
