package com.eggs;

import java.util.ArrayList;
import java.util.List;

/**
 * This class maintains an immutable list of menus.
 * 
 * @author lalyos
 * 
 */
public class MenuRepository {

    private List<Menu> menus = new ArrayList<Menu>();

    public MenuRepository() {
    }

    public MenuRepository(List<Menu> menus) {
        this.menus = menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Menu> getAllmenu() {
        return menus;
    }
}
