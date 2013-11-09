package com.eggs.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan(basePackageClasses={com.eggs.repo.inmemory.InmemoryMenuRepository.class,com.eggs.console.ConsoleMenuPrinter.class})
@Profile("default")
public class DefaultConfiguration {
}
