package com.eggs.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.eggs.Menu;
import com.eggs.MenuBuilder;
import com.eggs.MenuRepository;

public class CsvFileMenuPrinter implements MenuRepository {
	
	private List<Menu> menus = new ArrayList<Menu>();
	
	public CsvFileMenuPrinter(String[] args){
		
		File folder = new File("./src/main/resources");
		File[] listOfFiles = folder.listFiles();
		folder.delete();
		//Building menus from every csv files found in the resources folder
		for(File file : listOfFiles){
			if(file.getName().contains(".csv")){
				try{
					BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(file.getName())));
					String rest = file.getName().replace(".csv","");
					MenuBuilder mb = MenuBuilder.menu()
							.restaurant(rest);
					String line;			
					line = br.readLine();
					while(line != null){
						mb.food(line.split(",")[0], line.split(",")[1], Float.parseFloat(line.split(",")[2]));
						line = br.readLine();
					}			
					menus.add(mb.build());
					br.close();
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//Building menus from the csv files given as arguments
		for(String file : args){
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(file)));
				String rest = file.replace(".csv", "");
				
				MenuBuilder mb = MenuBuilder.menu()
								.restaurant(rest);
				String line;			
				line = br.readLine();
				while(line != null){
					mb.food(line.split(",")[0], line.split(",")[1], Float.parseFloat(line.split(",")[2]));
					line = br.readLine();
				}			
				menus.add(mb.build());
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	public List<Menu> getAllmenu(){
		return menus;
	}
}
