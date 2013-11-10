package com.eggs.configuration;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.eggs.domain.Address;
import com.eggs.order.OrderInstance;
import com.eggs.order.OrderItem;

@Configuration
@Profile("order")
@ComponentScan(basePackageClasses={com.eggs.order.OrderTaker.class, 
                                   com.eggs.repo.ComponentScanHelper.class,
                                   com.eggs.domain.AnnotatedApp.class})
public class OrderConfiguration {
  
    @Bean
    public Address address(){
        Address address = new Address();
        address.setCity("Budapest");
        address.setStreet("Juhasz Gyula utca 48");
        address.setZip("1039");
        return address;
    }
    
    @Bean
    public OrderInstance orderinstance(){
        return new OrderInstance("Valyi Csaba", address());
    }
    
    @Bean
    public List<OrderItem> orders(){
        List<OrderItem> orders = new ArrayList<OrderItem>();
        orders.add(new OrderItem("k1", 4));
        orders.add(new OrderItem("m1", 2));
        orders.add(new OrderItem("k3", 1));
        orders.add(new OrderItem("k2", 3));
        orders.add(new OrderItem("k3", 11));
        return orders;
    }
    
    @PostConstruct
    public void init(){
        orderinstance().setItems(orders());
    }
}
