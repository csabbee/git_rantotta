package com.eggs.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eggs.domain.Menu;


public abstract class BaseMenuPrinter implements MenuPrinter {

    private MenuRepository menuRepository;
    private static final Logger logger = LoggerFactory.getLogger(BaseMenuPrinter.class);

    public BaseMenuPrinter(MenuRepository menuRepository) {
        logger.debug("## BASE constr called: {}", menuRepository);
        this.menuRepository = menuRepository;
    }
    
    public void printMenus() {
        for (Menu menu : menuRepository.getAllmenu()) {
            printSingleMenu(menu);
        }
    }

    protected abstract void printSingleMenu(Menu menu);
}
