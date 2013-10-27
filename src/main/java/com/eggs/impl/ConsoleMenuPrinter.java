package com.eggs.impl;

import com.eggs.BaseMenuPrinter;
import com.eggs.Food;
import com.eggs.Menu;
import com.eggs.MenuRepository;
import com.gtranslate.Language;
import com.gtranslate.Translator;

public class ConsoleMenuPrinter extends BaseMenuPrinter {

    public ConsoleMenuPrinter(MenuRepository menuRepository) {
        super(menuRepository);
    }

    @Override
    protected void printSingleMenu(Menu menu) {
    	Translator translate = Translator.getInstance();
        System.out.format("%n=== %s ===%n", menu.getRestaurant().toString());
        for (Food food : menu.getFoodList()) {
            System.out.format(" - %-20s : %10.2f %n", translate.translate(food.getName(), Language.HUNGARIAN, Language.FRENCH), food.getPrice());
        }
    }

}
