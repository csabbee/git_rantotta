package com.eggs;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public class MenuValidator {
    
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    
    public static void validateFood(String id, String name, float price){
       validateObject(new Food(id, name, price));
    }
    public static void validateObject(Object obj){
        Set<ConstraintViolation<Object>> validations = validator.validate(obj);
        if(! validations.isEmpty()){
            ConstraintViolation<Object> errorMessage = validations.iterator().next();
            String message = errorMessage.getMessage();
            String field = errorMessage.getPropertyPath().toString();
            throw new FoodValidationException(field, message);
        }
    }
    public static void validateMenu(Menu menu){
        validateObject(menu);
    }
}