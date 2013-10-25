package com.eggs;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/*
 * TODO! I bet this will have to be refactored
 * Customer should be an entity of its own
 * And we already have an Address object
 */
public class Order {
    private String customer;
    private Address deliveryAddress;
    private List<OrderItem> orders = new ArrayList<OrderItem>();

    @NotNull @Length(min=3)
    public String getCustomer() {
        return customer;
    }

    /*
     * TODO! revise constraints!
     */
    @NotNull @Length(min=5)
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<OrderItem> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderItem> orders) {
        this.orders = orders;
    }
    
    

}
