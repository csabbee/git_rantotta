package com.eggs.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MenuBuilder {

    @Autowired
    private Menu menu;
    @Autowired
    private ApplicationContext ctx;
    
    
    public MenuBuilder restaurant(String name) {
        menu.setRestaurant(new Restaurant(name));
        return this;
    }

    public MenuBuilder food(String id, String name, float price) {
        Food food = ctx.getBean(Food.class);
        //Food food = new Food(id, name, price);
        food.setName(name);
        food.setPrice(price);
        food.setId(id);
        menu.addFood(food);
        return this;
    }

    public Menu build() {
        return menu;
    }
}
