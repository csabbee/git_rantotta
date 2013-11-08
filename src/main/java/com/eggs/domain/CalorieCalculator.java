package com.eggs.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CalorieCalculator implements ApplicationListener<MenuEvent> {

    private static final Logger logger = LoggerFactory.getLogger(CalorieCalculator.class);
    
    public void onApplicationEvent(MenuEvent event) {
        for (Food food : event.getMenu().getFoodList()) {
            logger.warn("Please calculate calorie for: {}", food.getName());
        }
        
    }

}
