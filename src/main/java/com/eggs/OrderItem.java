package com.eggs;

import javax.validation.constraints.Min;

public class OrderItem {
    private int quantity;
    private String foodId;
    
    public OrderItem(int quantity, String foodId){
        this.quantity = quantity;
        this.foodId = foodId;
    }
    
    @Min(1)
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    //TODO! Need to validate that foodId exists!
    public String getFoodId() {
        return foodId;
    }
    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

}
