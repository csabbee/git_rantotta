package com.eggs;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public class AllAroundValidator {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    
    public static void validateObject(Object obj) {
        Set<ConstraintViolation<Object>> validations = validator.validate(obj);
        if (! validations.isEmpty()) {
            ConstraintViolation<Object> firstError = validations.iterator().next();
            String message = firstError.getMessage();
            String field = firstError.getPropertyPath().toString();
            throw new FoodValidationException(field, message);
        }        
    }

    public static void validateMenu(Menu menu) {
        validateObject(menu);
    }

    public static void validateOrder(OrderInstance order){
        validateObject(order);
    }
}
