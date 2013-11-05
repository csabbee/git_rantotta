package com.eggs;

import org.springframework.context.ApplicationEvent;

public class FoodEvent extends ApplicationEvent {

    public FoodEvent(Food food) {
        super(food);
    }
    
    public Food getFood() {
        return (Food) getSource();
    }
    
}
