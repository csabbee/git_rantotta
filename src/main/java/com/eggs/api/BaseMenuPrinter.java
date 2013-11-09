package com.eggs.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eggs.domain.Menu;


public abstract class BaseMenuPrinter implements MenuPrinter {

    private List<MenuRepository> menuRepository = new ArrayList<MenuRepository>();
    private static final Logger logger = LoggerFactory.getLogger(BaseMenuPrinter.class);

    public BaseMenuPrinter(MenuRepository... menuRepository) {        
        for (MenuRepository repo : menuRepository) {
            logger.debug("## BASE constr called: {}", repo);
            this.menuRepository.add(repo);
        }
    }
    
    public void printMenus() {
        for (MenuRepository repo : menuRepository){
            for (Menu menu : repo.getAllmenu()) {
                printSingleMenu(menu);
            }
        }
    }

    protected abstract void printSingleMenu(Menu menu);
}
