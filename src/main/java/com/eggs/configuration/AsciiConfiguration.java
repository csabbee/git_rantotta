package com.eggs.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.eggs.ascii.AsciiArtPrinter;
import com.eggs.domain.BaseMenuPrinter;
import com.eggs.domain.MenuRepository;
import com.eggs.yaml.YamlFileMenuRepositoryReader;

@Configuration
@ComponentScan(basePackageClasses={AsciiArtPrinter.class, YamlFileMenuRepositoryReader.class})
@Profile("ascii")
public class AsciiConfiguration {

    @Autowired
    @Qualifier("yaml")
    MenuRepository repo;

    @Autowired
    @Qualifier("ascii")
    BaseMenuPrinter printer;

}
