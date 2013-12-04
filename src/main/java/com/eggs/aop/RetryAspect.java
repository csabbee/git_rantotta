package com.eggs.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class RetryAspect extends BaseAspect{

    private final Logger logger = LoggerFactory.getLogger(RetryAspect.class);
    
    @Around("annotatedWithRetry()")
    public Object tryAgain(ProceedingJoinPoint joinPoint){
        Object retValue = null;
        logger.warn("The first try of {}", joinPoint.getTarget());
        try {
            retValue = joinPoint.proceed();
        } catch (Throwable e) {
            try {
                logger.warn("The second try of {}", joinPoint.getTarget());
                retValue = joinPoint.proceed();
            } catch (Throwable e1) {
                try {
                    logger.warn("The third try of {}", joinPoint.getTarget());
                    retValue = joinPoint.proceed();
                } catch (Throwable e2) {
                    logger.warn("The third try failed");
                    e2.printStackTrace();
                }
                //e1.printStackTrace();
            }
            //e.printStackTrace();
        }
        return retValue;
    }
}
