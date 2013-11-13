package com.eggs.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
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
  
    @Autowired
    private OrderInstance orderinstance;
    
    @Bean
    public Address address(){
        Address address = new Address();
        address.setCity("Budapest");
        address.setStreet("Juhasz Gyula utca 48");
        address.setZip("1039");
        return address;
    }
    
    @Bean
    public String customer(){
        return "Valyi Csaba";
    }
    @Bean
    public OrderItem item1(){
        return new OrderItem("k1", 4);
    }
    @Bean
    public OrderItem item2(){
        return new OrderItem("m1", 2);
    }
    @Bean
    public OrderItem item3(){
        return new OrderItem("k3", 3);
    }
    @Bean
    public OrderItem item4(){
        return new OrderItem("k2", 3);
    }
    @Bean
    public OrderItem item5(){
        return new OrderItem("k3", 11);
    }
    @Bean
    public OrderItem item6(){
        return new OrderItem("m1", 6);
    }
    public Map<String, OrderItem> orders(){
        Map<String, OrderItem> orders = new HashMap<String, OrderItem>();
        orders.put("k1", new OrderItem("k1", 4));
        orders.put("m1", new OrderItem("m1", 2));
        orders.put("k3", new OrderItem("k3", 3));
        orders.put("k2", new OrderItem("k2", 3));
        orders.put("k3", new OrderItem("k3", 11));
        return orders;
    }
    
    @PostConstruct
    public void init(){
        orderinstance.addOrderItem(item1());
        orderinstance.addOrderItem(item2());
        orderinstance.addOrderItem(item3());
        orderinstance.addOrderItem(item4());
        orderinstance.addOrderItem(item5());
        orderinstance.addOrderItem(item6());
    }
}
