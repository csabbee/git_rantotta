package com.eggs.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

import com.eggs.order.OrderTaker;

@Component
public class OrderCommands implements CommandMarker {

    @Autowired
    OrderTaker ordertaker;
    
    @CliAvailabilityIndicator({"hw simple"})
    public boolean isCommandAvailable() {
      return true;
    }

    @CliCommand(value = "hw simple", help = "Print a simple hello world message")
    public String simple(
      @CliOption(key = { "message" }, mandatory = true, help = "The hello world message") final String message,
      @CliOption(key = { "location" }, mandatory = false, help = "Where you are saying hello", specifiedDefaultValue="At work") 
                   final String location) {

    return "Message = [" + message + "] Location = [" + location + "]";
    }
    
    @CliCommand("listMenus")
    public String listMenus(){
        return ordertaker.printMenus();
    }
    
    
}
