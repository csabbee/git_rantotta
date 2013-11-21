package com.eggs.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAspect {

    private static final Logger logger = LoggerFactory.getLogger(HelloAspect.class);
    
    @Before("execution( * com.eggs.domain.*.set*(..) )")
    public void hello() {
        logger.warn("Hello AOP");
    }
}
