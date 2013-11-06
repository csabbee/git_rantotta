package com.eggs;

import java.beans.PropertyEditorSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressEditor extends PropertyEditorSupport {

    private Logger logger = LoggerFactory.getLogger(AddressEditor.class);
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        logger.debug("try to '{}' to address:" , text);
        String[] addressParts = text.split(",");
        Address address = new Address();
        address.setZip(addressParts[0].trim());
        address.setCity(addressParts[1].trim());
        address.setStreet(addressParts[2].trim());
        logger.debug("addredd: {}", address);
        setValue(address);
    }

    
}
