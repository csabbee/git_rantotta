package com.eggs;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
/**
 * This class provides an interface to take the orders
 * @author Csaba_Valyi
 *
 */
public class OrderInstance {
    @NotNull @Length(min=10,max=40)
    private String customer;
    private Address delivery;
    private List<OrderItem> item;
    
    public OrderInstance(String customer, Address delivery) {
        this.customer = customer;
        this.delivery = delivery;
    }
    
    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    @Valid
    public Address getDelivery() {
        return delivery;
    }
    public void setDelivery(Address delivery) {
        this.delivery = delivery;
    }
    @Valid
    public List<OrderItem> getItem() {
        return item;
    }
    public void setItem(List<OrderItem> item) {
        this.item = item;
    }
    public void addOrderItem(OrderItem orderItem){
        item.add(orderItem);
    }
    public void addOrderItem(String foodId, int quantity){
        addOrderItem(new OrderItem(foodId, quantity));
    }
}
