package com.naidiuk.service;

import com.naidiuk.entity.Client;
import com.naidiuk.entity.Product;
import com.naidiuk.entity.ProductType;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
    List<Client> getAllClientsOverEighteen();
    List<Client> getAllClientsWithOneOrMoreProduct();
    List<Client> getAllClientsWithAlcoholProductType();

    List<Product> getAllProducts();
    List<Product> getAllClientAddedProducts(int clientId);
    List<Product> getProductsThatClientCanBuyBasedOnHisCardBalance(int clientId);
    List<Product> sortProductsByManufacturedDateInAscending();
    List<Product> sortProductsByManufacturedDateInDescending();
    List<Product> sortProductsByExpirationDateInAscending();
    List<Product> sortProductsByExpirationDateInDescending();
    List<Product> sortProductsByProductType();
    List<Product> getAllProductsWithProductType(ProductType productType);

    void addProduct(int clientId, Product product);
    void deleteOneClientProduct(int clientId, Product product);
    void deleteAllClientProducts(int clientId);
    void updateClientInformation(Client updatedClient);
}
