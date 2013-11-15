package com.eggs.command;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.PostConstruct;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import com.eggs.configuration.MenuConfiguration;
import com.eggs.domain.Address;
import com.eggs.order.OrderInstance;
import com.eggs.order.OrderItem;
import com.eggs.order.OrderPrinter;
import com.eggs.order.OrderState;
import com.eggs.order.OrderTaker;

@Component
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
    
    @CliAvailabilityIndicator({"saveOrderRepository"})
    public boolean isSaveOrderRepositoryAvailable(){
        return ordertaker.getOrderrepo().getOrderIntances().isEmpty() ? false : true;
    }
    
    @CliCommand(value="listMenus", help="List the available menus")
    public String listMenus(){
        return ordertaker.printMenus();
    }
    
    @CliCommand(value="setAddress", help="Setting the address")
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
                                    + "Won't run if there is an open order already !*) - " 
                                    + "Creates the order instance")
    public void createOrder(){       
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
    
    @CliCommand(value="saveOrderRepository", help="Saves the current OrderRepository")
    public void saveOrderRepository(){
        Yaml yaml = new Yaml();
        String yamlOutput = yaml.dumpAll(ordertaker.getOrderrepo().getOrderIntances().iterator());
        File file = new File("orderrepo.yaml");
        try {
            FileWriter filewriter = new FileWriter(file, true);
            BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
            bufferedwriter.append(yamlOutput);
            bufferedwriter.close();
            System.out.format("OrderRepository saved!%n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @CliCommand(value="loadOrderRepository", help="Loads the OrderRepository")
    public void loadOrderRepository(){
        Constructor constructor = new Constructor(OrderInstance.class);
        TypeDescription orderInstanceDescription = new TypeDescription(OrderInstance.class);
        orderInstanceDescription.putMapPropertyType("items", String.class, OrderItem.class);
        constructor.addTypeDescription(orderInstanceDescription);
        Yaml yaml = new Yaml(constructor);
        try {
            InputStream input = new FileInputStream(new File("orderrepo.yaml"));
            Iterable<Object> iter = yaml.loadAll(input);
            for (Object object : iter) {
                ordertaker.getOrderrepo().getOrderIntances().add((OrderInstance)object);
            }
            System.out.format("OrderRepository loaded!%n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
