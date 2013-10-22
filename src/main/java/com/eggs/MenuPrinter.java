package com.eggs;
/**
 * This class prints out the content of the menus contained by
 * the MenuRepository class
 * @author Csaba_Valyi
 *
 */
public abstract class MenuPrinter {
	
	private MenuRepository menuRepository;
	
	public MenuPrinter(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}
	
	public void printMenus() {
		for (Menu menu : menuRepository.getAllMenu()) {
			printSingleMenu(menu);
		}
	}

	protected  abstract void printSingleMenu(Menu menu);
}
