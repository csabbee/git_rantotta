package com.eggs;

public class FoodValidator {

    public static void validateFood(String id, String name, float price) {
        if (id == null || id.length() < 2) {
            throw new FoodValidationException("id", "id should be at least 2 characters");
        }
        
        if (name == null || name.length() < 3) {
            throw new FoodValidationException("name", "name should be at least 3 characters");            
        }
        
        if (price < 0) {
            throw new FoodValidationException("price", "price should be at least 0");
        }
    }

    public static void validateFood(Food food) {
        validateFood(food.getId(), food.getName(), food.getPrice());
    }
}
