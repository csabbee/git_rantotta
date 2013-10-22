package com.eggs;

public class MenuBuilder {

    private Menu menu = new Menu();

    private MenuBuilder() {
    }

    public static MenuBuilder menu() {
        return new MenuBuilder();
    }

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
