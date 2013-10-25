package com.eggs;

import org.hibernate.validator.constraints.Length;

public class Address {
    private String street;
    private String city;
    @Length(min=4, max=4, message="zip's length must be 4")
    private String zip;

    public Address(){
        
    }
    public Address(String street, String city, String zip) {
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s, %s", zip, city.toUpperCase(), street);
    }

}
