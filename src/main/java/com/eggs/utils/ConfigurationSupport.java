package com.eggs.utils;

public class ConfigurationSupport {

    public static String getConfig(String key, String def) {
        String envValue = System.getenv(key.toUpperCase().replace(".", "_"));
        return envValue != null ? envValue : System.getProperty(key, def); 
    }
}
    