package com.lpdm.msuser.beans;

import javax.persistence.Entity;

@Entity
public class Address {

    private double number;
    private String street;
    private String zipcode;
    private City city;

    public Address() {
    }

    public Address(double number, String street, String zipcode, City city) {
        this.number = number;
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "number=" + number +
                ", street='" + street + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", city=" + city +
                '}';
    }
}
