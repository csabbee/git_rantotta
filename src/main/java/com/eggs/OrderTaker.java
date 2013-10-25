package com.eggs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eggs.impl.YamlFileMenuRepositoryReader;
/**
 * This class is for to take orders and print them on the console
 * @author Csaba_Valyi
 *
 */
public class OrderTaker {
    private Random random = new Random();
    private List<OrderInstance> order = new ArrayList<OrderInstance>();
    private Logger logger = LoggerFactory.getLogger(OrderTaker.class);
    
    private void createOrder(MenuRepository menuRepo){
        logger.debug("createOrder method started");
        OrderInstance customer = new OrderInstance("Beviz Elek", new Address("Fostalicska Avenue","Crapville","1234"));
        logger.debug("{} {}",customer.getCustomer().toString(),customer.getDelivery());
        for(int i=0; i<5; i++)
            customer.addOrderItem(pickRandomFood(menuRepo.getAllmenu().get((int)(random.nextDouble()*menuRepo.getAllmenu().size()))));
        logger.debug("OrderItem added to customer");
        AllAroundValidator.validateOrder(customer);
        order.add(customer);
        
        
        
        printOrders();
    }
    private OrderItem pickRandomFood(Menu menu){
        logger.info("pickRandomFood method started");
        OrderItem oi = new OrderItem(menu.getFoodList().get((int)(random.nextDouble()*menu.getFoodList().size())).getId(), (int)((random.nextDouble())*5));
        System.out.format("id: %s quantity: %d%n", oi.getFoodId(), oi.getQuantity());
        logger.debug("OrderItem created");
        return oi;
    }
    private void printOrders(){
        logger.info("Now printing out the orders...");
        for(OrderInstance o : order){
            System.out.format(" Customer: %-30s%n Address: %s %n", o.getCustomer(), o.getDelivery());
            for(OrderItem oi : o.getItem()){
                System.out.format(" FoodId: %-3s Quantity: %5d%n",oi.getFoodId(), oi.getQuantity());
            }
        }
    }
    public static void main(String[] args) {
        YamlFileMenuRepositoryReader reader = new YamlFileMenuRepositoryReader("menus.yml");
        OrderTaker orderTaker = new OrderTaker();
        orderTaker.createOrder(reader.read());
        
        
    }
}
