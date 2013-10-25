package com.eggs;

public class OrderBuilder {
    private Order order= new Order();
    
    public OrderBuilder order(){
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
