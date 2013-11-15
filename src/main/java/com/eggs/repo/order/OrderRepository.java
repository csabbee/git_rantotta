package com.eggs.repo.order;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.eggs.order.OrderInstance;

@Component
@Lazy
public class OrderRepository {

    private List<OrderInstance> orderintances = new ArrayList<OrderInstance>();
    private final Logger logger = LoggerFactory.getLogger(OrderRepository.class);
    
    public OrderRepository(){}
    
    public OrderRepository(OrderInstance... orderinstances){
        for (OrderInstance orderInstance : orderinstances) {
            this.orderintances.add(orderInstance);
        }
    }

    public List<OrderInstance> getOrderIntances() {
        return orderintances;
    }

    public void setOrderInstances(List<OrderInstance> orderinstances) {
        this.orderintances = orderinstances;
    }

    @Override
    public String toString() {
        StringBuilder everyorderinstance = new StringBuilder();
        for (OrderInstance orderinstance : orderintances) {
            everyorderinstance.append(orderinstance+"\n");
        }
        return everyorderinstance.toString();
    }
}
