package com.eggs;

public class FoodValidationException extends RuntimeException {

    private String fieldName;

    public FoodValidationException(String field, String message) {
        // TODO Auto-generated constructor stub
        super(message);
        this.fieldName = field;
    }
    public String getFieldName() {
        return fieldName;
    }
}
