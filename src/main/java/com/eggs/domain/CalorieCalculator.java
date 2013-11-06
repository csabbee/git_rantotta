package com.eggs.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CalorieCalculator implements ApplicationListener<FoodEvent> {

    private static final Logger logger = LoggerFactory.getLogger(CalorieCalculator.class);
    
    public void onApplicationEvent(FoodEvent event) {
        logger.warn("Please calculate calorie for: {}", event.getFood().getName());
    }

}
