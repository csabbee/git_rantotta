package com.eggs.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.eggs.Menu;
import com.eggs.MenuBuilder;
import com.eggs.MenuRepository;
import com.eggs.MenuRepositoryReader;

@Component
@Qualifier("memory")
public class InmemoryMenuRepositoryReader implements MenuRepositoryReader {

    private static final Logger logger = LoggerFactory.getLogger(InmemoryMenuRepositoryReader.class);
    private List<Menu> menus = new ArrayList<Menu>();

    @Autowired
    private ApplicationContext ctx;
    
    public InmemoryMenuRepositoryReader() {
    }
    
    @PostConstruct
    public void init() {
        logger.error("init called");
        createFirstMenu();
        createSecondMenu();
    }

    private void createFirstMenu() {
        logger.equals("createFirstMenu()");
        MenuBuilder builder = ctx.getBean(MenuBuilder.class);
        menus.add(builder.restaurant("Karesz")
                .food("k1", "hagymas bab", 450)
                .food("k2", "krumplis hal", 540)
                .build());

    }

    private void createSecondMenu() {
        MenuBuilder builder = ctx.getBean(MenuBuilder.class);
        menus.add(builder.restaurant("Mercello")
                .food("m1", "csokis nokkedli", 250)
                .food("m2", "furj tojas", 890)
                .food("m3", "dinnyes palacsinta", 1490)
                .build());

    }

    public List<Menu> getAllmenu() {
        return menus;
    }

    public MenuRepository read() {
        return new MenuRepository(menus);
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

}
