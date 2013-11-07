package com.eggs.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eggs.console.ConsoleMenuPrinter;
import com.eggs.interfaces.MenuPrinter;

public class App {
    private static Logger logger = LoggerFactory.getLogger(App.class);

    private static void printReader(MenuRepositoryReader reader) {
        ConsoleMenuPrinter printer = new ConsoleMenuPrinter();
        printer.setReader(reader);
        printer.printMenus();
    }

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        
        MenuPrinter printer = ctx.getBean(MenuPrinter.class);
        printer.printMenus();        
    }
}
