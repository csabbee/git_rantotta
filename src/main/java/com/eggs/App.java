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
		
		//printer.printMenus();
		DumperOptions options = new DumperOptions();
	    options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
	    Yaml yml = new Yaml(options);
	    
	    Yaml yml2 = new Yaml(new Constructor(Food.class));
	    
	    Object obj = repo.getAllmenu().get(0).getFoodList();
	    System.out.println(yml2.dump(obj));
	    //System.out.println(yml2.dump(repo.getAllmenu().get(0)));
	    
	}
}
