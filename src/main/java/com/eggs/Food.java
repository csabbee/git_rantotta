package com.eggs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Food {

	private String id;
	private String name;
	private String description;
	private float price;
	private int calories;
	private static Logger logger = LoggerFactory.getLogger(Food.class);

	public Food(String id, String name, float price, int calories) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.calories = calories;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		logger.info("In setId");
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		logger.info("In setName");
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		logger.info("In setPrice");
		this.price = price;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public Food() {
		
	}

	public Food(String id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

}
