package com.eggs.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eggs.api.MenuPrinter;

public class App {
    @SuppressWarnings("unused")
    private static Logger logger = LoggerFactory.getLogger(App.class);


    public static void main(String[] args) {

        @SuppressWarnings("resource")
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        
        MenuPrinter printer = ctx.getBean(MenuPrinter.class);
        printer.printMenus();
        }
}
