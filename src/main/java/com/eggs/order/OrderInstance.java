package com.eggs.order;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eggs.domain.Address;
/**
 * This class provides an interface to take the orders
 * @author Csaba_Valyi
 *
 */
@Component
public class OrderInstance {
    @NotNull @Length(min=10,max=40)
    private String customer;
    private Address delivery;
    private List<OrderItem> items = new ArrayList<OrderItem>();

    @Autowired
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
    public List<OrderItem> getItems() {
        return items;
    }
    public void setItems(List<OrderItem> item) {
        this.items = item;
    }
    public void addOrderItem(OrderItem orderItem){
        items.add(orderItem);
    }
    public void addOrderItem(String foodId, int quantity){
        addOrderItem(new OrderItem(foodId, quantity));
    }

    @Override
    public String toString() {
        String orderitems = "";
        for (OrderItem orderitem : items) {
            orderitems+= orderitem + "\n";
        }
        return "OrderInstance [customer=" + customer + ", delivery=" + delivery + ", \nitems:\n" + orderitems + "]";
    }
}
