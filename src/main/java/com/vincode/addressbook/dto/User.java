package com.vincode.addressbook.dto;

public class User {
    private static int nextId = 1;
    private final int userId;
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = nextId;
        nextId++;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "User{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + '}';
    }
}
