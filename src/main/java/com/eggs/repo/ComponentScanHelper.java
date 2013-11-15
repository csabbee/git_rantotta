package com.eggs.repo;

import org.springframework.jmx.access.InvalidInvocationException;

public final class ComponentScanHelper {

    private ComponentScanHelper(){
        throw new InvalidInvocationException("Do not instantiate");
    }
}
