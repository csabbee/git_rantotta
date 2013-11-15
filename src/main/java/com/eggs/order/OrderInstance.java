package com.eggs.order;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.eggs.domain.Address;
/**
 * This class provides an interface to take the orders
 * @author Csaba_Valyi
 *
 */
@Component
@Scope("prototype")
@Lazy
public class OrderInstance {
    @NotNull @Length(min=10,max=40)
    private String customer;
    private Address delivery;
    private Map<String, OrderItem> items = new HashMap<String, OrderItem>();
    private final Logger logger = LoggerFactory.getLogger(OrderInstance.class);

    public OrderInstance(){}
    
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

    public void addOrderItem(OrderItem orderItem){
        logger.debug("adding orderitem: {} ",orderItem);
        if(items.containsKey(orderItem.getFoodId())){
            logger.debug("the item is in the map");
            OrderItem item = items.get(orderItem.getFoodId());
            item.setQuantity(item.getQuantity()+orderItem.getQuantity());
            items.put(item.getFoodId(), item);
        } else {
            items.put(orderItem.getFoodId(), orderItem);
        }
    }
    public void addOrderItem(String foodId, int quantity){
        addOrderItem(new OrderItem(foodId, quantity));
    }
    public Map<String, OrderItem> getItems() {
        return items;
    }
    public void setItems(Map<String, OrderItem> items) {
        this.items = items;
    }
    @Override
    public String toString() {
        return String.format(" %-20s%n %-20s%n items:%n %s",customer,delivery,items);
    }
}
