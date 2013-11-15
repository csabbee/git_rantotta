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
    
    public String printOrders(){
        StringBuilder orders = new StringBuilder();
        for (OrderInstance orderinstance : orderrepo.getOrderIntances()) {
            orders.append(String.format(" orderid: %s orderstate: %s%n", orderinstance.getId(), orderinstance.getOrderstate()));
            orders.append(String.format(" customer: %s%n", orderinstance.getCustomer()));
            orders.append(String.format(" delivery address: %s%n",orderinstance.getDelivery()));
            for (OrderItem orderitem : orderinstance.getItems().values()) {
                orders.append(orderitem);
            }
            
        }
        return String.format(" orders:%n%s", orders);
    }
}
