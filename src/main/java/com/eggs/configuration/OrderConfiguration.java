package com.eggs.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("order")
@ComponentScan(basePackageClasses={com.eggs.order.OrderTaker.class, 
                                   com.eggs.repo.ComponentScanHelper.class,
                                   com.eggs.domain.AnnotatedApp.class})
public class OrderConfiguration {
    
}
