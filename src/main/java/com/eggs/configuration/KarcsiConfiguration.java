package com.eggs.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.eggs.domain.Address;
import com.eggs.domain.Restaurant;

@Configuration
public class KarcsiConfiguration {

    @Bean
    public Restaurant karcsi() {
        Restaurant rest = new Restaurant("karcsi");
        rest.setAddress(epamAddress());
        
        return rest;
    }
    
    @Bean
    public Address epamAddress() {
        Address epam = new Address();
        epam.setZip("1082");
        epam.setStreet("Futo 47");
        epam.setCity("Budapest");
        
        return epam;
    }
}
