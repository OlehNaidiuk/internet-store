package com.naidiuk.entity;

import java.time.LocalDateTime;
import java.util.Comparator;

public class Product {
    private int id;
    private String name;
    private ProductType productType;
    private LocalDateTime manufacturedDate;
    private LocalDateTime expirationDate;
    private double price;
    private double discount;

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

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public LocalDateTime getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(LocalDateTime manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "\nProduct\n{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productType=" + productType +
                ", manufacturedDate=" + manufacturedDate +
                ", expirationDate=" + expirationDate +
                ", price=" + price +
                ", discount=" + discount +
                "}";
    }
}
