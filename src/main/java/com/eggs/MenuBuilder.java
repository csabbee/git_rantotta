package com.eggs;

import org.springframework.beans.factory.annotation.Autowired;

public class MenuBuilder {

    @Autowired
    private Menu menu;

    public MenuBuilder restaurant(String name) {
        menu.setRestaurant(new Restaurant(name));
        return this;
    }

    public MenuBuilder food(String id, String name, float price) {
        Food food = new Food(id, name, price);
        menu.addFood(food);
        return this;
    }

    public Menu build() {
        return menu;
    }
}
