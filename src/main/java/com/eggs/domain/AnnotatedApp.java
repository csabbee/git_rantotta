package com.eggs.domain;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eggs.api.MenuPrinter;
import com.eggs.configuration.MenuConfiguration;

public class AnnotatedApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MenuConfiguration.class);
        
        
        MenuPrinter printer = ctx.getBean(MenuPrinter.class);
        printer.printMenus();
    }

}
