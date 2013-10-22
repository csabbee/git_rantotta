package com.eggs;

import com.eggs.impl.ConsoleMenuPrinter;
import com.eggs.impl.CsvFileMenuRepositoryReader;
import com.eggs.impl.YamlFileMenuRepositoryReader;

public class App {
	public static void main(String[] args) {
//		CsvFileMenuRepositoryReader reader = new CsvFileMenuRepositoryReader("karcsi", "marcello");
		YamlFileMenuRepositoryReader reader = new YamlFileMenuRepositoryReader("menus.yml");
		ConsoleMenuPrinter printer = new ConsoleMenuPrinter(reader.read());
		
	    printer.printMenus();
	}
}
