package com.eggs.domain;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eggs.configuration.OrderConfiguration;
import com.eggs.order.OrderInstance;
import com.eggs.order.OrderTaker;

public class OrderApp {

    public static void main(String[] args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(OrderConfiguration.class);
        
        OrderInstance oi = ctx.getBean(OrderInstance.class);
        System.out.format("====%nOrder:%n%s%n====", oi);
        @SuppressWarnings("unused")
        OrderTaker ordetaker = new OrderTaker();
        ctx.close();
    }
}
