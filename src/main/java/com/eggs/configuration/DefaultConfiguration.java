package com.eggs.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.eggs.MenuPrinter;
import com.eggs.impl.ConsoleMenuPrinter;
import com.eggs.impl.InmemoryMenuRepositoryReader;

@Configuration
@Profile("default")
public class DefaultConfiguration {
    
    @Bean
    public MenuPrinter consolePrinter() {
        return new ConsoleMenuPrinter(reader());
    }

    @Bean(initMethod="init")
    public InmemoryMenuRepositoryReader reader() {
        return new InmemoryMenuRepositoryReader();
    }

}
