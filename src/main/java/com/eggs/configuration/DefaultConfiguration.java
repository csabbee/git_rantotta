package com.eggs.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.eggs.interfaces.BaseMenuPrinter;
import com.eggs.repo.inmemory.InmemoryMenuRepository;

@Configuration
@ComponentScan(basePackageClasses={com.eggs.repo.inmemory.InmemoryMenuRepository.class,com.eggs.console.ConsoleMenuPrinter.class})
@Profile("default")
public class DefaultConfiguration {

    @Autowired
    InmemoryMenuRepository reader;

    @Autowired
    BaseMenuPrinter printer;

}
