package com.eggs;

public class OrderValidator extends ValidatorBase {
    
    public static void validateOrder(Order order){
        validateObject(order);        
    }
}
