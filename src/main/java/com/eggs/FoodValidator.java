package com.eggs;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validation;
import javax.validation.Validator;

public class FoodValidator {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    
    public static void validateFood(String id, String name, float price) {
        validateFood(new Food(id,name,price));
    }

    public static void validateFood(Food food) {
        Set<ConstraintViolation<Food>> validations = validator.validate(food);
        if (! validations.isEmpty()) {
            ConstraintViolation<Food> firstError = validations.iterator().next();
            String message = firstError.getMessage();
            String field = firstError.getPropertyPath().toString();
            throw new FoodValidationException(field, message);
        }
    }
}
