package com.eggs.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(4)
public class RezsiAspect extends BaseAspect{

    @Around("annotatedWithCache()")
    public Object decrease(ProceedingJoinPoint joinPoint){
        float newPrice = 0;
        
        try {
            float originalValue = (Float) joinPoint.proceed();
            newPrice = originalValue * 0.85f;
        } catch (Throwable e) {
            //e.printStackTrace();
        }
        return newPrice;
    }
}
