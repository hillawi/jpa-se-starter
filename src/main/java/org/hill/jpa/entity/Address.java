package org.hill.jpa.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Hillawi on 10-09-17.
 */
@Embeddable
public class Address {
    private String country;
    private String city;
    private String locality;
    private String street;
    @Column(name = "STREET_NUMBER")
    private int streetNumber;

    public Address() {
    }

    public Address(String country, String city, String locality, String street, int streetNumber) {
        this.country = country;
        this.city = city;
        this.locality = locality;
        this.street = street;
        this.streetNumber = streetNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
