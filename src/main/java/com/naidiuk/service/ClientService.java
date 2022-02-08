package com.naidiuk.service;

import com.naidiuk.entity.Product;

public interface ClientService {
    void addProduct(Product product);
    void showAllProducts();
    void sortProductsByManufacturedDateInAscending();
    void sortProductsByManufacturedDateInDescending();
    void sortProductsByExpirationDateInAscending();
    void sortProductsByExpirationDateInDescending();
    void sortProductsByProductType();
    void editData();
    void deleteOneProduct();
    void deleteAllProducts();
    void showProductsThatClientCanBuyBasedOnHisBalance();
}
