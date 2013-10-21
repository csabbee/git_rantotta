package com.eggs;

public abstract class BaseMenuPrinter implements MenuPrinter {
	
	private final MenuRepository menuRepository;
	
	public BaseMenuPrinter(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}
	
	/* (non-Javadoc)
	 * @see com.eggs.MenuPrinter#printMenus()
	 */
	public void printMenus() {
		for (Menu menu : menuRepository.getAllmenu()) {
			printSingleMenu(menu);
		}
	}

	protected  abstract void printSingleMenu(Menu menu);
}
