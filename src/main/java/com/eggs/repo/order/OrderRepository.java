package com.eggs.repo.order;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.eggs.order.OrderInstance;

@Component
@Lazy
public class OrderRepository {

    private List<OrderInstance> orderrepo = new ArrayList<OrderInstance>();
    private final Logger logger = LoggerFactory.getLogger(OrderRepository.class);
    
    @Autowired
    public OrderRepository(OrderInstance... orderinstances){
        for (OrderInstance orderInstance : orderinstances) {
            orderrepo.add(orderInstance);
        }
    }

    public List<OrderInstance> getOrderrepo() {
        return orderrepo;
    }

    public void setOrderrepo(List<OrderInstance> orderrepo) {
        this.orderrepo = orderrepo;
    }

    @Override
    public String toString() {
        StringBuilder orderinstances = new StringBuilder();
        for (OrderInstance orderinstance : orderrepo) {
            orderinstances.append(orderinstance);
        }
        return orderinstances.toString();
    }
}
