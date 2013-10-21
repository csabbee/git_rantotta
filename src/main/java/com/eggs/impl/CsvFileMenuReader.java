package com.eggs.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eggs.App;
import com.eggs.Menu;
import com.eggs.MenuBuilder;
import com.eggs.MenuRepository;
import com.eggs.MenuRepositoryReader;

public class CsvFileMenuReader implements MenuRepositoryReader {
	
	private List<Menu> menus = new ArrayList<Menu>();
	private static Logger logger = LoggerFactory.getLogger(App.class);
	
	public CsvFileMenuReader(String[] args){
		
		File folder = new File("./src/main/resources");
		File[] listOfFiles = folder.listFiles();
		folder.delete();
		//Building menus from every csv files found in the resources folder
		logger.info("Now entering resource folder file list parsing loop");
		for(File file : listOfFiles){
			logger.debug(file.getName());
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
		logger.info("Now entering the argument list parsing loop");
		for(String file : args){
			logger.debug(file);
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
	public MenuRepository read() {
		// TODO Auto-generated method stub
		return new MenuRepository(menus);
	}
}
