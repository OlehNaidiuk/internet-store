package com.naidiuk.entity;

import com.naidiuk.service.ClientService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Client implements ClientService {
    private int id;
    private String name;
    private String surname;
    private int age;
    private LocalDate dateOfBirth;
    private String cardNumber;
    private double cardBalance;
    private List<Product> products;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "\nClient\n{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", dateOfBirth=" + dateOfBirth +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardBalance=" + cardBalance +
                ", products=" + products +
                '}';
    }

    @Override
    public void addProduct(Product product) {
        if (products == null) {
            products = new ArrayList<>();
        }
        products.add(product);
    }

    @Override
    public void showAllProducts() {
        if (products == null || products.isEmpty()) {
            System.out.println("Your basket is empty");
        }
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Override
    public void sortProductsByManufacturedDateInAscending() {
        Comparator<Product> sortByManufacturedDateInAscendingComparator =
                (o1, o2) -> o1.getManufacturedDate().compareTo(o2.getManufacturedDate());
        products.sort(sortByManufacturedDateInAscendingComparator);
    }

    @Override
    public void sortProductsByManufacturedDateInDescending() {
        Comparator<Product> sortByManufacturedDateInDescendingComparator =
                (o1, o2) -> o2.getManufacturedDate().compareTo(o1.getManufacturedDate());
        products.sort(sortByManufacturedDateInDescendingComparator);
    }

    @Override
    public void sortProductsByExpirationDateInAscending() {

    }

    @Override
    public void sortProductsByExpirationDateInDescending() {

    }

    @Override
    public void sortProductsByProductType() {

    }

    @Override
    public void editData() {

    }

    @Override
    public void deleteOneProduct() {

    }

    @Override
    public void deleteAllProducts() {

    }

    @Override
    public void showProductsThatClientCanBuyBasedOnHisBalance() {

    }
}
