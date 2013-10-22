package com.eggs;

import org.apache.log4j.Logger;

import com.eggs.impl.ConsoleMenuPrinter;
import com.eggs.impl.CsvFileMenuRepositoryReader;
import com.eggs.impl.YamlFileMenuRepositoryReader;

public class App {
	private static Logger logger = Logger.getLogger(App.class);
	
	private static void printReader(MenuRepositoryReader reader) {
		ConsoleMenuPrinter printer = new ConsoleMenuPrinter(reader.read());
		
	    printer.printMenus();
	}
	
	public static void main(String[] args) {
		
		String fileName = args[0];
		logger.info("reading menu from:" + fileName);
		
		CsvFileMenuRepositoryReader csvReader = new CsvFileMenuRepositoryReader("karcsi", "marcello");
		YamlFileMenuRepositoryReader yamlReader = new YamlFileMenuRepositoryReader(fileName);

		printReader(csvReader);
		printReader(yamlReader);		
	}
}
