package com.eggs.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TraceAspect {

    private final Logger logger = LoggerFactory.getLogger(TraceAspect.class);
    
    @Around("execution(* get*())")
    public Object trace(ProceedingJoinPoint joinPoint){
        Object retValue = null;
        
        try {
            long startTime = System.nanoTime();
            retValue = joinPoint.proceed();
            long endTime = System.nanoTime();
            logger.warn("ellapsed time {} [ns]", (endTime-startTime));
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return retValue;
    }
}
