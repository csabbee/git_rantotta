package com.eggs;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import com.eggs.impl.ConsoleMenuPrinter;
import com.eggs.impl.InmemoryMenuRepository;

public class App {
	public static void main(String[] args) {
		MenuRepository repo = new InmemoryMenuRepository();
		ConsoleMenuPrinter printer = new ConsoleMenuPrinter(repo);
		
	    printer.printMenus();
	}
}
