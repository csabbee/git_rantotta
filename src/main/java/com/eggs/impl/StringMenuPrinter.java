package com.eggs.impl;

import com.eggs.BaseMenuPrinter;
import com.eggs.Food;
import com.eggs.Menu;
import com.eggs.MenuRepository;

public class StringMenuPrinter extends BaseMenuPrinter {

    public StringMenuPrinter(MenuRepository menuRepository) {
        super(menuRepository);
    }
    
    StringBuilder builder = new StringBuilder();
    @Override
    protected void printSingleMenu(Menu menu) {
        for (Food food : menu.getFoodList()) {
            String line = String.format(" - [%3s] %-20s : %10.2f %n", food.getId(), food.getName(), food.getPrice());
            builder.append(line);
        }
    }
    
    public String getMenuString() {
        return builder.toString();
    }

}
