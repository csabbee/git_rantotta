package com.eggs.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class VegetarianMenuSelector implements ApplicationListener<MenuEvent>{

    private static final Logger logger = LoggerFactory.getLogger(VegetarianMenuSelector.class);
    public void onApplicationEvent(MenuEvent event) {
        logger.error("pleace decide weather {} is vegetarian !", event.getMenu().toString());
        
    }

}
