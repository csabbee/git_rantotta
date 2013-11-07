package com.eggs.interfaces;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eggs.domain.Menu;
import com.eggs.domain.MenuRepositoryReader;


public abstract class BaseMenuPrinter implements MenuPrinter {

    private MenuRepository menuRepository;
    protected MenuRepositoryReader reader;
    private static final Logger logger = LoggerFactory.getLogger(BaseMenuPrinter.class);

    public BaseMenuPrinter(MenuRepository menuRepository) {
        logger.debug("## BASE constr called: {}", menuRepository);
        this.menuRepository = menuRepository;
    }

    public void init() {
        menuRepository = reader.read();
    }
    
    public void setReader(MenuRepositoryReader reader) {
        this.reader = reader;
        init();
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
