package com.eggs.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RezsiAspect {

    @Around("execution(* getPrice())")
    public Object decrease(ProceedingJoinPoint joinPoint){
        float newPrice = 0;
        
        try {
            float originalValue = (Float) joinPoint.proceed();
            newPrice = originalValue * 0.85f;
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return newPrice;
    }
}
