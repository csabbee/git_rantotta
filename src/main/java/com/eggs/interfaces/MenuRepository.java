package com.eggs.interfaces;

import java.util.List;

import com.eggs.domain.Menu;

/**
 * This interface hands back a list of menus
 * 
 * @author lalyos
 * 
 */
public interface MenuRepository {

    List<Menu> getAllmenu();
}
