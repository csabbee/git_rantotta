package com.eggs;

import java.util.ArrayList;
import java.util.List;

/**
 * This class maintains a list of menus.
 * @author lalyos
 *
 */
public class MenuRepository {
	
	private List<Menu> menus = new ArrayList<Menu>();
	
	public MenuRepository(List<Menu> menus){
		this.menus = menus;
	}
	List<Menu> getAllMenu(){
		return menus;
	}
}
