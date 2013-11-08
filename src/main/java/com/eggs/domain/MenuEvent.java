package com.eggs.domain;

import org.springframework.context.ApplicationEvent;

public class MenuEvent extends ApplicationEvent {

    public MenuEvent(Menu menu) {
        super(menu);
    }
    
    public Menu getMenu() {
        return (Menu) getSource();
    }
    
}
