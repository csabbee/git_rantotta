package com.eggs.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.eggs.api.MenuPrinter;
import com.eggs.repo.yaml.YamlFileMenuRepository;

@Configuration
@ComponentScan(basePackageClasses={com.eggs.repo.ComponentScanHelper.class, 
               com.eggs.ascii.AsciiArtPrinter.class})
@Profile("compound")
public class CompoundConfiguration {

    @Autowired
    YamlFileMenuRepository repo;
    
    @Autowired
    MenuPrinter printer;
}
