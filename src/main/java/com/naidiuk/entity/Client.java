package com.naidiuk.entity;

import com.naidiuk.service.ClientService;

import java.time.LocalDate;
import java.util.ArrayList;
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
        checkClientBasket();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Override
    public void sortProductsByManufacturedDateInAscending() {
        checkClientBasket();
        Comparator<Product> sortByManufacturedDateInAscendingComparator =
                (o1, o2) -> o1.getManufacturedDate().compareTo(o2.getManufacturedDate());
        products.sort(sortByManufacturedDateInAscendingComparator);
    }

    @Override
    public void sortProductsByManufacturedDateInDescending() {
        checkClientBasket();
        Comparator<Product> sortByManufacturedDateInDescendingComparator =
                (o1, o2) -> o2.getManufacturedDate().compareTo(o1.getManufacturedDate());
        products.sort(sortByManufacturedDateInDescendingComparator);
    }

    @Override
    public void sortProductsByExpirationDateInAscending() {
        checkClientBasket();
        Comparator<Product> sortByExpirationDateInAscendingComparator =
                (o1, o2) -> o1.getExpirationDate().compareTo(o2.getExpirationDate());
        products.sort(sortByExpirationDateInAscendingComparator);
    }

    @Override
    public void sortProductsByExpirationDateInDescending() {
        checkClientBasket();
        Comparator<Product> sortByExpirationDateInDescendingComparator =
                (o1, o2) -> o2.getExpirationDate().compareTo(o1.getExpirationDate());
        products.sort(sortByExpirationDateInDescendingComparator);
    }

    @Override
    public void sortProductsByProductType() {
        checkClientBasket();
        Comparator<Product> sortProductsByProductTypeComparator =
                (o1, o2) -> o1.getProductType().compareTo(o2.getProductType());
        products.sort(sortProductsByProductTypeComparator);
    }

    @Override
    public void editData() {

    }

    @Override
    public void deleteOneProduct() {
        checkClientBasket();

    }

    @Override
    public void deleteAllProducts() {
        checkClientBasket();
        products.clear();
    }

    @Override
    public void showProductsThatClientCanBuyBasedOnHisCardBalance() {
        checkClientBasket();

    }

    private void checkClientBasket() {
        if (products == null || products.isEmpty()) {
            throw new RuntimeException("Your basket is empty");
        }
    }
}
