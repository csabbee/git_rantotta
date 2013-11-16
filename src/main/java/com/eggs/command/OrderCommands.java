package com.eggs.command;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

import com.eggs.configuration.MenuConfiguration;
import com.eggs.domain.Address;
import com.eggs.order.OrderInstance;
import com.eggs.order.OrderItem;
import com.eggs.order.OrderPrinter;
import com.eggs.order.OrderState;
import com.eggs.order.OrderTaker;

@Component
@Lazy
public class OrderCommands implements CommandMarker {

    private boolean addressIsSet  = false;
    private boolean customerIsSet = false;
    private boolean thereIsAnOpenOrder = false;
    private boolean thereIsFoodInTheOrder = false;
    
    private AnnotationConfigApplicationContext ctx;
    private OrderTaker ordertaker;
    private Address address;
    private String customer;
    private OrderInstance orderinstance;
    private OrderItem orderitem;
    private OrderPrinter orderprinter;
    
    
    @PostConstruct
    public void init(){
        ctx = new AnnotationConfigApplicationContext(MenuConfiguration.class);
        ordertaker = ctx.getBean(OrderTaker.class);
        orderprinter = ctx.getBean(OrderPrinter.class);
    }
    
    @CliAvailabilityIndicator({"createOrder"})
    public boolean isOrderAvailable(){
        return addressIsSet && customerIsSet && !thereIsAnOpenOrder ? true : false;
    }
    
    @CliAvailabilityIndicator({"addFood", "showOrder"})
    public boolean isAddFoodAvailable(){
        return thereIsAnOpenOrder ? true : false;
    }
    
    @CliAvailabilityIndicator({"submitOrder"})
    public boolean isSubmitOrderAvailable(){
        return thereIsFoodInTheOrder ? true : false;
    }
    
    
    @CliCommand(value="listMenus", help="Lists the available menus")
    public String listMenus(){
        return ordertaker.printMenus();
    }
    
    @CliCommand(value="setAddress", help="Sets the address")
    public String address(
        @CliOption(key = {"zip"},    mandatory = true) final String zip,
        @CliOption(key = {"city"},   mandatory = true) final String city,
        @CliOption(key = {"street"}, mandatory = true) final String street){
        
            address = new Address();
            address.setCity(city);
            address.setStreet(street);
            address.setZip(zip);
            addressIsSet = true;
            return address.toString();
    }
    
    @CliCommand(value="setCustomer", help="Sets the customer's name")
    public String customer(
            @CliOption(key = {"name"}, mandatory = true) final String name){
        customer = name;
        customerIsSet = true;
        return customer;
    }
    
    @CliCommand(value="createOrder", help="(*! setAddress and setCustomer must be executed first. "
                                    + " Will fail if there is an open order already !*) - " 
                                    + "Creates the order instance")
    public void order(){       
        orderinstance = new OrderInstance(customer, address, ordertaker.getNumberOfOrders());
        thereIsAnOpenOrder = true;
    }
    
    @CliCommand(value="addFood", help="(*! createOrder must be executed first !*) "
                                    + "- Adds food to the order instance")
    public void addFood(
        @CliOption(key = {"id"}, mandatory = true) final String id,
        @CliOption(key = {"quantity"}, mandatory = false, help="if not given it will be 1",
                            specifiedDefaultValue="1") final int quantity){
        
        orderitem = new OrderItem(id, quantity);
        orderinstance.addOrderItem(orderitem);
        thereIsFoodInTheOrder = true;
    }
    
    @CliCommand(value="showOrder", help="(*! createOrder must be executed first !*) " +
                                    "- Shows the current customer's order")
    public String showOrder(){
        return orderinstance.toString();
    }
    
    @CliCommand(value="submitOrder", help="Submits the customer's order")
    public String submitOrder(){
        thereIsAnOpenOrder = false;
        thereIsFoodInTheOrder = false;
        ordertaker.addOrder(orderinstance);
        return customer+"'s order submitted";
    }
    
    @CliCommand(value="listOrders", help="Lists the orders, return blank line if there is no order")
    public String listOrders(){
        return ordertaker.getOrderrepo().getOrderIntances().isEmpty() ? "" : orderprinter.printOrders();
    }
    
    @CliCommand(value="setOrderState", help="Sets the state of the order")
    public String setOrderState(
        @CliOption(key={"id"}, mandatory=true, help="Give the ID of the OrderInstance") final int id,
        @CliOption(key={"state"}, mandatory=true, help="Can be: PENDING, IN_DELIVERY, DELIVERED, CLOSED") final OrderState orderstate
            ){ 
        OrderInstance oi = ordertaker.findOrderInstance(id);
        oi.setOrderstate(orderstate);
        return "customer: "+oi.getCustomer();
    }
}
