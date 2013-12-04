package com.eggs.aop;

import org.aspectj.lang.annotation.Pointcut;

public class BaseAspect {

    @Pointcut("execution(@com.eggs.aop.Kess * *(..))")
    public void annotatedWithCache(){
        
    }
    @Pointcut("execution(@com.eggs.aop.Retry * *(..))")
    public void annotatedWithRetry(){
        
    }
}
