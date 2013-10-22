package com.eggs.impl;

import java.util.ArrayList;
import java.util.List;

import com.eggs.Menu;
import com.eggs.MenuBuilder;
import com.eggs.MenuRepository;
import com.eggs.MenuRepositoryReader;

public class InmemoryMenuRepositoryReader implements MenuRepositoryReader {

    private List<Menu> menus = new ArrayList<Menu>();

    public InmemoryMenuRepositoryReader() {
        createFirstMenu();
        createSecondMenu();
    }

    private void createFirstMenu() {
        menus.add(MenuBuilder.menu().restaurant("Karesz").food("k1", "hagymas rantotta", 450).food("k2", "ham and eggs", 540)
                .food("k3", "kroasszon", 320).build());

    }

    private void createSecondMenu() {
        menus.add(MenuBuilder.menu().restaurant("Mercello").food("m1", "Margherita", 250).food("m2", "grilled cat", 890).food("m3", "ostriga", 1490)
                .build());

    }

    public List<Menu> getAllmenu() {
        return menus;
    }

    public MenuRepository read() {
        return new MenuRepository(menus);
    }

}
