package com.eggs;

public class FoodValidationException extends RuntimeException {
    
    private String fieldName;
    
    public FoodValidationException(String field, String message) {
        super(message);
        this.fieldName = field;
    }

    public String getFieldName() {
        return fieldName;
    }
    
}
