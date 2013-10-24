package com.eggs;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class Food {

    @NotNull @Length(min=2,message="id should be at least 2")
    private String id;
    
    @NotNull @Length(min=3, max=15, message="name should be minimum 3 max 15 characters")
    private String name;
    
    private String description;
    
    @Range(min=0, max=100000, message="price should be in the range of [0,10000]")
    private float price;
    
    private int calories;

    public Food(String id, String name, float price, int calories) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
