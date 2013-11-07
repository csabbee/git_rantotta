package com.eggs.domain;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eggs.configuration.MenuConfiguration;
import com.eggs.interfaces.MenuPrinter;

public class AnnotatedApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MenuConfiguration.class);
        
        
        MenuPrinter printer = ctx.getBean(MenuPrinter.class);
        printer.printMenus();
    }

}
