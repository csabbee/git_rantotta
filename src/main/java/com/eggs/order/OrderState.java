package com.eggs.order;

public enum OrderState {

    indelivery("IN_DELIVERY"),
    pending("PENDING"),
    delivered("DELIVERED"),
    closed("CLOSED");
    
    private final String state;
    
    private OrderState(String state){
        this.state = state;
    }
    public String getState() {
        return state;
    }
}
