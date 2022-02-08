package com.naidiuk.mok_dao.service;

import com.naidiuk.entity.Client;
import com.naidiuk.entity.Product;

import java.util.List;

public interface DataService {
    List<Client> getClients();
    List<Product> getProducts();
    List<Client> getClientsWithTheirProducts();
}
