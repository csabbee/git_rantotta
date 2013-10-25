package com.eggs;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
/**
 * This class represents an item in an order
 * @author Csaba_Valyi
 *
 */
public class OrderItem {
    @NotNull
    private int quantity;
    @NotNull @Length(min=2,max=3)
    private String foodId;
    
    public OrderItem(String foodId, int quantity) {
        this.quantity = quantity;
        this.foodId = foodId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getFoodId() {
        return foodId;
    }
    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }
    

}
