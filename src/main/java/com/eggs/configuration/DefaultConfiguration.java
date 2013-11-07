package com.eggs.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.eggs.impl.InmemoryMenuRepository;
import com.eggs.interfaces.BaseMenuPrinter;

@Configuration
@ComponentScan(basePackageClasses={com.eggs.impl.ImplPackageScanSupport.class,com.eggs.console.ConsoleMenuPrinter.class})
@Profile("default")
public class DefaultConfiguration {

    @Autowired
    InmemoryMenuRepository reader;

    @Autowired
    @Qualifier("console")
    BaseMenuPrinter printer;
}
