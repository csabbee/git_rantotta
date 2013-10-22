package com.eggs.impl;

import com.eggs.Food;
import com.eggs.Menu;
import com.eggs.MenuPrinter;
import com.eggs.MenuRepository;
/**
 * This class prints out a single menu to the console
 * @author Csaba_Valyi
 *
 */
public class ConsoleMenuPrinter extends MenuPrinter {
	
	public ConsoleMenuPrinter(MenuRepository menuRepository) {
		super(menuRepository);
	}

	@Override
	protected void printSingleMenu(Menu menu) {
		System.out.format("%n=== %s ===%n", menu.getRestaurant().getName());
		for (Food food : menu.getFoodList()) {
			System.out.format(" - %-4s %-20s : %10.2f %n", food.getId(),food.getName(), food.getPrice());
		}
	}

}
