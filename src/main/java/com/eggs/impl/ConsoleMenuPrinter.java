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
        System.out.format("%n=== %s ===%n", menu.getRestaurant().toString());
        for (Food food : menu.getFoodList()) {
            System.out.format(" - %-20s : %10.2f %n", food.getName(), food.getPrice());
        }
    }

}
