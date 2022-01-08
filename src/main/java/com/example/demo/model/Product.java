package com.example.demo.model;


public class Product {
    private int id;
    private String name;
    private String yearOfMake;
    private int amount;

    public Product() {
    }
    public Product(int id, String name, String yearOfMake, int amount) {
        this.id = id;
        this.name = name;
        this.yearOfMake = yearOfMake;
        this.amount = amount;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getYearOfMake() {
        return yearOfMake;
    }
    public void setYearOfMake(String yearOfMake) {
        this.yearOfMake = yearOfMake;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void addAmount(int amount)
    {
        this.amount += amount;
    }
    public void removeAmount(int amount)
    {
        this.amount -= amount;
    }
}

//
//public class Product {
//
//
//    private String id;
//    private String username;
//    private String yearOfMake;
//    private String amount;
//
//    public Product(String id, String username, String yearOfMake, String amount) {
//        this.id = id;
//        this.username = username;
//        this.yearOfMake = yearOfMake;
//        this.amount = amount;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getYearOfMake() {
//        return yearOfMake;
//    }
//
//    public void setYearOfMake(String yearOfMake) {
//        this.yearOfMake = yearOfMake;
//    }
//
//    public String getAmount() {
//        return amount;
//    }
//
//    public void setAmount(String amount) {
//        this.amount = amount;
//    }
//}
