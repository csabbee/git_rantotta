package com.eggs.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class HelloAspect {

    private static final Logger logger = LoggerFactory.getLogger(HelloAspect.class);
    
    @Before("execution( * get*(..) )")
    public void hello(JoinPoint joinPoint) {
        logger.warn("Hello AOP method: {}", joinPoint.getSignature());
        Object[] args = joinPoint.getArgs();
        for (Object object : args) {
            logger.warn(" next ARG: {}", object);
        }
    }
}
