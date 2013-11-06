package com.eggs.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.eggs.MenuPrinter;
import com.eggs.impl.AsciiArtPrinter;
import com.eggs.impl.YamlFileMenuRepositoryReader;

@Configuration
@Profile("ascii")
public class AsciiConfiguration {

    @Bean
    public MenuPrinter asciiPrinter() {
        return new AsciiArtPrinter(new YamlFileMenuRepositoryReader());
    }

}
