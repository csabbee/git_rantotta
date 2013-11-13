package com.eggs.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.eggs.repo.order.OrderRepository;

@Component
@Lazy
public class OrderPrinter {

    private OrderRepository orderrepo;
    
    @Autowired
    public OrderPrinter(OrderRepository orderrepo){
        this.orderrepo = orderrepo;
    }
}
