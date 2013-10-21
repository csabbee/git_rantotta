package com.eggs;

import com.eggs.impl.ConsoleMenuPrinter;
import com.eggs.impl.CsvFileMenuRepositoryReader;

public class App {
	public static void main(String[] args) {
		CsvFileMenuRepositoryReader reader = new CsvFileMenuRepositoryReader("karcsi", "marcello");
		ConsoleMenuPrinter printer = new ConsoleMenuPrinter(reader.read());
		
	    printer.printMenus();
	}
}
