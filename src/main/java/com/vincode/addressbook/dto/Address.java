package com.vincode.addressbook.dto;

public class Address {
    private static int nextId = 1;
    private final int addressId;
    private int houseNumber;
    private String firstLineOfAddress;
    private String city;
    private String state;
    private String postcode;

    public Address(int houseNumber, String firstLineOfAddress, String city, String state, String postcode) {
        this.houseNumber = houseNumber;
        this.firstLineOfAddress = firstLineOfAddress;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.addressId = nextId;
        nextId++;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getFirstLineOfAddress() {
        return firstLineOfAddress;
    }

    public void setFirstLineOfAddress(String firstLineOfAddress) {
        this.firstLineOfAddress = firstLineOfAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getAddressId() {
        return addressId;
    }

    @Override
    public String toString() {
        return "Address{" + "houseNumber=" + houseNumber + ", firstLineOfAddress='" + firstLineOfAddress + '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + ", postcode='" + postcode + '\'' + '}';
    }
}
