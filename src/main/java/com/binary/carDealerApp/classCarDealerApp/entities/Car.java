package com.binary.carDealerApp.classCarDealerApp.entities;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String brand, model, color, regNumber, imageUrl;
    private int year;
    @Column(name = "car_price", nullable = false)
    private double price;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dealer")
    private Dealer dealer;

    public Car() {

    }

    public Car(String brand, String model, String color, String regNumber, String imageUrl, int year, double price, Dealer dealer) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.regNumber = regNumber;
        this.imageUrl = imageUrl;
        this.year = year;
        this.price = price;
        this.dealer = dealer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", dealer=" + dealer +
                '}';
    }
}