package com.eggs.jmx;

import com.eggs.MenuRepository;
import com.eggs.impl.StringMenuPrinter;

public class BreakFast implements BreakFastMBean {

    private StringMenuPrinter printer;
    
    public BreakFast(MenuRepository repo) {
        this.printer = new StringMenuPrinter(repo);
        printer.printMenus();

    }
    
    public void printMessage(String msg) {
        System.out.println("### MSG=" + msg);

    }

    public String printAllMenus() {
        String menus = printer.getMenuString();
        return menus;
    }

}
