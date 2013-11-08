package com.eggs;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eggs.impl.YamlFileMenuRepositoryReader;
/**
 * This class is for to take orders and print them on the console
 * @author Csaba_Valyi
 *
 */
public class OrderTaker {

    private List<OrderInstance> order = new ArrayList<OrderInstance>();
    private Logger logger = LoggerFactory.getLogger(OrderTaker.class);
    
    private void createOrder(MenuRepository menuRepo){
        logger.debug("createOrder method started");
        OrderInstance customer = new OrderInstance("Beviz Elek", new Address("Fostalicska Avenue","Crapville","1234"));
        for(int i=0; i<5; i++)
            customer.addOrderItem(pickRandomFood(menuRepo.getAllmenu().get((int)Math.random()*menuRepo.getAllmenu().size())));
        order.add(customer);
        
        
        
        printOrders();
    }
    private OrderItem pickRandomFood(Menu menu){
        logger.debug("pickRandomFood method started");
        return new OrderItem(menu.getFoodList().get((int)Math.random()*menu.getFoodList().size()).getId(), (int)Math.random()*5);
    }
    private void printOrders(){
        logger.info("Now printing out the orders...");
        for(OrderInstance o : order){
            System.out.format(" Customer: %-30s%n Address: %s %n", o.getCustomer(), o.getDelivery());
            for(OrderItem oi : o.getItem()){
                System.out.format(" FoodId: %-3s%n Quantity: %30d",oi.getFoodId(), oi.getQuantity());
            }
        }
    }
    public static void main(String[] args) {
        YamlFileMenuRepositoryReader reader = new YamlFileMenuRepositoryReader("menus.yml");
        OrderTaker orderTaker = new OrderTaker();
        orderTaker.createOrder(reader.read());
        
        
    }
}
