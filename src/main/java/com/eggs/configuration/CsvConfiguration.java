package com.eggs.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.eggs.api.MenuPrinter;
import com.eggs.repo.csv.CsvFileMenuRepository;

@Configuration
@ComponentScan(basePackageClasses={com.eggs.repo.csv.CsvFileMenuRepository.class, com.eggs.console.ConsoleMenuPrinter.class})
@Profile("csv")
public class CsvConfiguration {

    @Autowired
    CsvFileMenuRepository reader;
    
    @Autowired
    MenuPrinter printer;
}
