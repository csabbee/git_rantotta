package com.eggs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eggs.configuration.KarcsiConfiguration;

public class AnnotatedApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(KarcsiConfiguration.class);
        
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.format("name=%s %n", name);
        }
        Restaurant restaurant = ctx.getBean(Restaurant.class);
        System.out.format("restaurant=%s %n", restaurant);
    }

}
