package com.eggs.order;

import org.springframework.beans.factory.annotation.Autowired;

import com.eggs.domain.Address;

public class OrderBuilder {
    @Autowired
    private Order order;
    
    public static OrderBuilder order(){
        return new OrderBuilder();
    }
    
    public OrderBuilder customer(String customer){
        this.order.setCustomer(customer);
        return this;
    }
    
    public OrderBuilder deliveryAddress(Address deliveryAddress){
        this.order.setDeliveryAddress(deliveryAddress);
        return this;
    }
    
    public OrderBuilder orderItem(int quantity, String foodId){
        this.order.getOrders().add(new OrderItem(quantity, foodId));
        return this;
    }
    
    public Order build(){
        return this.order;
    }
}