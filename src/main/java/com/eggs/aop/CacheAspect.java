package com.eggs.aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CacheAspect extends BaseAspect{

    private final Logger logger = LoggerFactory.getLogger(CacheAspect.class);
    private Map<Integer, Float> priceCache = new HashMap<>();
    
    @Around("annotatedWithCache()")
    public Object getPrice(ProceedingJoinPoint joinPoint){
        Object retValue = priceCache.get(joinPoint.getTarget().hashCode());
        long start = System.nanoTime();
        if(retValue == null){
            logger.warn("Cache miss");
            try {
                retValue = joinPoint.proceed();
                logger.warn("{}",retValue.hashCode());
                priceCache.put(joinPoint.getTarget().hashCode(), (Float)retValue);
            } catch (Throwable e) {
                //e.printStackTrace();
            }
            long endmiss = System.nanoTime();
            logger.warn("end miss: {} [ns]",(endmiss-start));
        } else {
            logger.warn("Cache hit");
            long endhit = System.nanoTime();
            logger.warn("end hit: {} [ns]",endhit-start);
        }
        
        return retValue;
    }
}
