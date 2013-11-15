package com.eggs.order;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eggs.api.MenuRepository;
import com.eggs.domain.Menu;
import com.eggs.repo.order.OrderRepository;
/**
 * This class is for to take orders and print them on the console
 * @author Csaba_Valyi
 *
 */
@Component
public class OrderTaker {

    //private List<OrderInstance> orders = new ArrayList<OrderInstance>();
    @SuppressWarnings("unused")
    private Logger logger = LoggerFactory.getLogger(OrderTaker.class);
    private List<MenuRepository> repos = new ArrayList<MenuRepository>();
    private int numberOfOrders = 1; 
    @Autowired
    private OrderRepository orderrepo;
    
    @Autowired
    public OrderTaker(MenuRepository... menuRepo){
        for (MenuRepository menuRepository : menuRepo) {
            repos.add(menuRepository);
        }
    }

    public String printMenus(){
        String menus = "";
        for (MenuRepository repo : repos) {
            for (Menu menu : repo.getAllmenu()) {
                menus+=String.format("%s %n", menu);
            }
        }
        return menus;
    }
    
    public void addOrder(OrderInstance orderinstance){
        orderrepo.getOrderIntances().add(orderinstance);
        numberOfOrders++;
    }

    public OrderRepository getOrderrepo() {
        return orderrepo;
    }

    public Integer getNumberOfOrders() {
        return numberOfOrders;
    }
    
    public OrderInstance findOrderInstance(int id){
        for (OrderInstance orderinstance : orderrepo.getOrderIntances()) {
            if(orderinstance.getId() == id){
                return orderinstance;
            }
        }
        return new OrderInstance("not valid", null, Integer.MAX_VALUE);
    }
}
