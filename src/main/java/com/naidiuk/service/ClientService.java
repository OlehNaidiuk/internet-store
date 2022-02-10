package com.naidiuk.service;

import com.naidiuk.entity.Client;
import com.naidiuk.entity.Product;
import com.naidiuk.entity.ProductType;

import java.util.List;

public interface ClientService {
    boolean addProduct(int clientId, Product product);

    List<Product> getAllClientAddedProducts(int clientId);

    List<Product> sortProductsByManufacturedDateInAscending();

    List<Product> sortProductsByManufacturedDateInDescending();

    List<Product> sortProductsByExpirationDateInAscending();

    List<Product> sortProductsByExpirationDateInDescending();

    List<Product> sortProductsByProductType();

    void updateClientInformation(Client updatedClient);

    boolean deleteOneClientProduct(int clientId, Product product);

    void deleteAllClientProducts(int clientId);

    List<Product> getProductsThatClientCanBuyBasedOnHisCardBalance(int clientId);

    List<Client> getAllClients();

    List<Product> getAllProducts();

    List<Product> getAllProductsWithProductType(ProductType productType);

    List<Client> getAllClientsOverEighteen();

    List<Client> getAllClientsWithOneOrMoreProduct();

    List<Client> getAllClientsWithAlcoholProductType();
}
