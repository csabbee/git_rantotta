package com.eggs;

public interface OrderRepository {
    public void listOrders();
    public String addOrder(Order order);
}
