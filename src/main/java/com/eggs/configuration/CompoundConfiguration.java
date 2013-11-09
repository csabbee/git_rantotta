package com.eggs.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan(basePackageClasses={com.eggs.repo.ComponentScanHelper.class, 
               com.eggs.ascii.AsciiArtPrinter.class})
@Profile("compound")
public class CompoundConfiguration {

}
