package com.eggs.domain;

import org.springframework.context.ApplicationEvent;

public class MenuEvent extends ApplicationEvent {

    /**
     * 
     */
    private static final long serialVersionUID = 2220381214448913760L;

    public MenuEvent(Menu menu) {
        super(menu);
    }
    
    public Menu getMenu() {
        return (Menu) getSource();
    }
    
}
