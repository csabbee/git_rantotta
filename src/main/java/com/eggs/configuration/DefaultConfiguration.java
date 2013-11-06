package com.eggs.configuration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.eggs.domain.BaseMenuPrinter;
import com.eggs.domain.MenuPrinter;
import com.eggs.domain.MenuRepositoryReader;
import com.eggs.impl.ConsoleMenuPrinter;
import com.eggs.impl.InmemoryMenuRepositoryReader;

@Configuration
@Profile("default")
public class DefaultConfiguration {

    @Autowired
    @Qualifier("memory")
    MenuRepositoryReader reader;

    @Autowired
    @Qualifier("console")
    BaseMenuPrinter printer;

    @PostConstruct
    public void wire() {
        printer.setReader(reader);
    }
    
    @Bean
    public MenuPrinter mainPrinter() {
        return printer;
    }

}
