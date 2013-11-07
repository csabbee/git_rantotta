package com.eggs.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.eggs.impl.YamlFileMenuRepository;
import com.eggs.interfaces.BaseMenuPrinter;

@Configuration
@ComponentScan(basePackageClasses={com.eggs.impl.ImplPackageScanSupport.class, com.eggs.ascii.AsciiArtPrinter.class})
@Profile("ascii")
public class AsciiConfiguration {

    @Autowired
    YamlFileMenuRepository reader;

    @Autowired
    @Qualifier("ascii")
    BaseMenuPrinter printer;
    
}
