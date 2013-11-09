package com.eggs.order;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eggs.api.MenuRepository;
import com.eggs.domain.Menu;
/**
 * This class is for to take orders and print them on the console
 * @author Csaba_Valyi
 *
 */
public class OrderTaker {

    private List<OrderInstance> order = new ArrayList<OrderInstance>();
    private Logger logger = LoggerFactory.getLogger(OrderTaker.class);
    
    private void createOrder(MenuRepository menuRepo){

    }
    private OrderItem pickRandomFood(Menu menu){

    }
    private void printOrders(){

    }
    public static void main(String[] args) {
        OrderTaker orderTaker = new OrderTaker();

        
        
    }
}
