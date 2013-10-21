package com.eggs;

import com.eggs.impl.ConsoleMenuPrinter;
import com.eggs.impl.YamlFileMenuRepositoryReader;

public class App {
	public static void main(String[] args) {
		//ConsoleMenuPrinter printer = new ConsoleMenuPrinter(new InmemoryMenuRepository().read());
		//ConsoleMenuPrinter printer = new ConsoleMenuPrinter(new CsvFileMenuReader(args).read());
		ConsoleMenuPrinter printer = new ConsoleMenuPrinter(new YamlFileMenuRepositoryReader().read());
	    printer.printMenus();
	}
}
