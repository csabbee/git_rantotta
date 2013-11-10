package com.eggs.order;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.eggs.api.MenuRepository;
import com.eggs.configuration.OrderConfiguration;
/**
 * This class is for to take orders and print them on the console
 * @author Csaba_Valyi
 *
 */
@Component
public class OrderTaker {

    private List<OrderInstance> orders = new ArrayList<OrderInstance>();
    private Logger logger = LoggerFactory.getLogger(OrderTaker.class);
    private List<MenuRepository> repos = new ArrayList<MenuRepository>();
    
    @Autowired
    public OrderTaker(MenuRepository... menuRepo){
        for (MenuRepository menuRepository : menuRepo) {
            repos.add(menuRepository);
        }
    }

    private void printOrders(){
        for (OrderInstance orderinstance : orders) {
            System.out.format("orderinstance=%s", orderinstance);
        }
    }
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(OrderConfiguration.class);
        
        OrderInstance oi = ctx.getBean(OrderInstance.class);
        System.out.format("oi=%s", oi);
    }
}
