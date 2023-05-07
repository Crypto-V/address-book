package com.vincode.addressbook.dto;

public class AddressBook {
    private static int nextId = 1;
    private final int id;
    private User user;
    private Address address;

    public AddressBook(User user, Address address) {
        this.user = user;
        this.address = address;
        this.id = nextId;
        nextId++;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "AddressBook{" + "user=" + user + ", address=" + address + '}';
    }
}
