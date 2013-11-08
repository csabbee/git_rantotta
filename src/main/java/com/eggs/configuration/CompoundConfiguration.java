package com.eggs.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.eggs.interfaces.MenuPrinter;
import com.eggs.repo.compound.CompoundMenuRepository;

@Configuration
@ComponentScan(basePackageClasses={com.eggs.repo.ComponentScanHelper.class, 
               com.eggs.compound.CompoundConsoleMenuPrinter.class})
@Profile("compound")
public class CompoundConfiguration {

    @Autowired
    CompoundMenuRepository repo;
    
    @Autowired
    MenuPrinter printer;
}
