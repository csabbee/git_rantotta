package com.eggs.impl;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.eggs.Food;
import com.eggs.Menu;
import com.eggs.BaseMenuPrinter;
import com.eggs.MenuRepository;
import com.eggs.MenuRepositoryReader;

public class ConsoleMenuPrinter extends BaseMenuPrinter implements ApplicationContextAware {

    
    private ApplicationContext ctx;
    private Locale locale;
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
        
        
        String nameHeader = ctx.getMessage("header.name", new Object[0], this.locale);
        String priceHeader = ctx.getMessage("header.price", new Object[0],  this.locale);
        
        System.out.format(" %-20s | %10s %n", nameHeader, priceHeader);
        
        for (Food food : menu.getFoodList()) {
            System.out.format(" %-20s | %10.2f %n", food.getName(), food.getPrice());
        }
    }
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
        
    }
    public Locale getLocale() {
        return locale;
    }
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

}
