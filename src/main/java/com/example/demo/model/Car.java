package com.example.demo.model;

public class Car {

    private String id;
    private String model;
    private String YearsOfMake;
    private String color;
    private String price;

    public Car(String id, String model, String YearsOfMake, String color, String price) {
        this.id = id;
        this.model = model;
        this.YearsOfMake = YearsOfMake;
        this.color = color;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYearOfMake() {
        return YearsOfMake;
    }

    public void setYearsOfMake(String YearsOfMake) {
        this.YearsOfMake = YearsOfMake;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
