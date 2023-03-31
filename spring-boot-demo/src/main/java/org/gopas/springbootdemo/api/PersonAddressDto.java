package org.gopas.springbootdemo.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonAddressDto {
    private Long id;
    private String city;
//    @JsonProperty(value = "house_number")
    private Integer houseNumber;
    private String zipCode;
    private String street;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "PersonAddressDto{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", houseNumber=" + houseNumber +
                ", zipCode='" + zipCode + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
