package com.eggs.api;

import java.util.List;

import com.eggs.domain.Menu;

/**
 * This interface hands back a list of menus
 * 
 * @author lalyos
 * 
 */
public interface MenuRepository {
    
    public List<Menu> getAllmenu();
    public void addMenu(Menu menu);
}
