package com.eggs;

import com.eggs.impl.ConsoleMenuPrinter;
import com.eggs.impl.YamlFileMenuRepositoryReader;
/**
 * This class is the entry point of the application
 * @author Csaba_Valyi
 *
 */
public class App {
	public static void main(String[] args) {
		//ConsoleMenuPrinter printer = new ConsoleMenuPrinter(new InmemoryMenuRepository().read());
		//ConsoleMenuPrinter printer = new ConsoleMenuPrinter(new CsvFileMenuReader(args).read());
		ConsoleMenuPrinter printer = new ConsoleMenuPrinter(new YamlFileMenuRepositoryReader().read());
	    printer.printMenus();
	}
}
