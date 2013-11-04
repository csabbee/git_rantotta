package com.eggs.impl;

import com.eggs.Food;
import com.eggs.Menu;
import com.eggs.BaseMenuPrinter;
import com.eggs.MenuRepository;
import com.eggs.MenuRepositoryReader;

public class ConsoleMenuPrinter extends BaseMenuPrinter {

    public ConsoleMenuPrinter() {
        super();
    }
    public ConsoleMenuPrinter(MenuRepositoryReader reader) {
    }

    @Override
    protected void printSingleMenu(Menu menu) {
        System.out.format(String.format("%n %-20s---%10s %n", "-", "-").replace(" ", "-"));
        System.out.format("%s : %s %n", "Restaurant", menu.getRestaurant().getName());
        System.out.format(String.format(" %-20s---%10s %n", "-", "-").replace(" ", "-"));
        System.out.format(" %-20s | %10s %n", "NAME", "PRICE");
        
        for (Food food : menu.getFoodList()) {
            System.out.format(" %-20s | %10.2f %n", food.getName(), food.getPrice());
        }
    }

}
