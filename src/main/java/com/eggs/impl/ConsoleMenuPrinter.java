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
        String name = menu.getRestaurant().getName();
        String fmt = "%-"+ (name.length() + 2 ) + "s";
        String padded = " " + String.format(fmt, "-").replace(" ", "-");
        System.out.println(padded);
        System.out.format("< %s >%n", name);       
        System.out.println(padded);
        System.out.println("        \\   ^__^");
        System.out.println("         \\  (oo)\\_______");
        System.out.println("            (__)\\       )\\/\\");
        System.out.println("                ||----w |");
        System.out.println("                ||     ||");
        
        System.out.format(String.format(" %-20s---%10s %n", "-", "-").replace(" ", "-"));
        System.out.format(" %-20s | %10s %n", "NAME", "PRICE");
        
        for (Food food : menu.getFoodList()) {
            System.out.format(" %-20s | %10.2f %n", food.getName(), food.getPrice());
        }
    }

}
