package com.naidiuk.mock_dao;

import com.naidiuk.entity.Client;
import com.naidiuk.entity.Product;

import java.util.List;

public interface MockDaoService {
    List<Client> getClientsList();
    List<Product> getProductsList();
}
