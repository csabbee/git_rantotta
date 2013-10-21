package com.eggs;

import com.eggs.impl.ConsoleMenuPrinter;
import com.eggs.impl.CsvFileMenuPrinter;
import com.eggs.impl.InmemoryMenuRepository;

import org.yaml.snakeyaml.*;

public class App {
	public static void main(String[] args) {
		MenuRepository repo = new InmemoryMenuRepository();
		ConsoleMenuPrinter printer = new ConsoleMenuPrinter(repo);
		
		
		MenuRepository repo2 = new CsvFileMenuPrinter(args);
		ConsoleMenuPrinter printer2 = new ConsoleMenuPrinter(repo2);
		
	    printer.printMenus();
	    printer2.printMenus();
	}
}
