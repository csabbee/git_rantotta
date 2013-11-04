package com.eggs;

public abstract class BaseMenuPrinter implements MenuPrinter {

    private MenuRepository menuRepository;
    private MenuRepositoryReader reader;

    public BaseMenuPrinter(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void init() {
        menuRepository = reader.read();
    }
    
    public void setReader(MenuRepositoryReader reader) {
        this.reader = reader;
    }
    public BaseMenuPrinter() {
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.eggs.MenuPrinter#printMenus()
     */
    public void printMenus() {
        for (Menu menu : menuRepository.getAllmenu()) {
            printSingleMenu(menu);
        }
    }

    protected abstract void printSingleMenu(Menu menu);
}
