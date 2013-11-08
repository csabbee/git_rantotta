package com.eggs.repo.compound;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eggs.domain.Menu;
import com.eggs.interfaces.MenuRepository;

@Component
public class CompoundMenuRepository implements MenuRepository{

    private List<Menu> menus = new ArrayList<Menu>();

    @Autowired
    public CompoundMenuRepository (MenuRepository...repos){
        for (MenuRepository menuRepository : repos) {
            for (Menu menu : menuRepository.getAllmenu()) {
                addMenu(menu);
            }
        }
    }
    public List<Menu> getAllmenu() {
        return menus;
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }
    
    
}
