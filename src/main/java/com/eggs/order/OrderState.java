package com.eggs.order;

public enum OrderState {

    IN_DELIVERY("IN_DELIVERY"),
    PENDING("PENDING"),
    DELIVERED("DELIVERED"),
    CLOSED("CLOSED");
    
    private final String state;
    
    private OrderState(String state){
        this.state = state;
    }
    @Override
    public String toString(){
        return state;
    }
}
