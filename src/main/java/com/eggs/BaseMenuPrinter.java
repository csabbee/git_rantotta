package com.eggs;

public abstract class BaseMenuPrinter implements MenuPrinter {

    private final MenuRepositoryReader reader;

    public BaseMenuPrinter(MenuRepositoryReader reader) {
        this.reader = reader;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.eggs.MenuPrinter#printMenus()
     */
    public void printMenus() {
        for (Menu menu : reader.read().getAllmenu()) {
            printSingleMenu(menu);
        }
    }

    protected abstract void printSingleMenu(Menu menu);
}
