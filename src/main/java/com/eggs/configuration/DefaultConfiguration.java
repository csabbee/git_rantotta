package com.eggs.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.eggs.console.ConsoleMenuPrinter;
import com.eggs.domain.BaseMenuPrinter;
import com.eggs.domain.MenuRepository;
import com.eggs.impl.InmemoryMenuRepositoryReader;

@Configuration
@Profile("default")
@ComponentScan(basePackageClasses={ConsoleMenuPrinter.class,InmemoryMenuRepositoryReader.class})
public class DefaultConfiguration {

    @Autowired
    @Qualifier("memory")
    MenuRepository repo;

    @Autowired
    @Qualifier("console")
    BaseMenuPrinter printer;

}
