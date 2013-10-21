package com.eggs;

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
