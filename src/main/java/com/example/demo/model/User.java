package com.example.demo.model;

public class User {

    private String id;
    private String username;
    private String yearOfMake;
    private String amount;

    public User(String id, String username, String yearOfMake, String amount) {
        this.id = id;
        this.username = username;
        this.yearOfMake = yearOfMake;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getYearOfMake() {
        return yearOfMake;
    }

    public void setYearOfMake(String yearOfMake) {
        this.yearOfMake = yearOfMake;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
