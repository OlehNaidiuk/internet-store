package com.naidiuk.service;

import com.naidiuk.entity.Client;
import com.naidiuk.entity.Product;

import java.util.List;

public interface ClientService {
    void addProduct(int clientId, Product product);
    List<Product> getAllAddedProducts(int clientId);
    List<Product> sortProductsByManufacturedDateInAscending();
    List<Product> sortProductsByManufacturedDateInDescending();
    List<Product> sortProductsByExpirationDateInAscending();
    List<Product> sortProductsByExpirationDateInDescending();
    List<Product> sortProductsByProductType();
    void updateClientInformation(Client updatedClient);
    void deleteOneClientProduct(int clientId, Product product);
    void deleteAllClientProducts(int clientId);
    List<Product> showProductsThatClientCanBuyBasedOnHisCardBalance(int clientId);
    List<Client> getAllClients();
    List<Product> getAllProducts();
    List<Product> getAllProductsWithProductType();
    List<Client> getAllClientsOverEighteen();
    List<Client> getAllClientsWithOneOrMoreProduct();
    List<Client> getAllClientsWithAlcoholProductType();
}
