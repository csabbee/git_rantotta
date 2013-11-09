package com.eggs.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.eggs.api.BaseMenuPrinter;
import com.eggs.repo.yaml.YamlFileMenuRepository;

@Configuration
@ComponentScan(basePackageClasses={com.eggs.repo.yaml.YamlFileMenuRepository.class, com.eggs.ascii.AsciiArtPrinter.class})
@Profile("ascii")
public class AsciiConfiguration {

    @Autowired
    YamlFileMenuRepository reader;

    @Autowired
    BaseMenuPrinter printer;
    
}
