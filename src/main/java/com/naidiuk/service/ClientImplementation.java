package com.naidiuk.service;

import com.naidiuk.entity.Client;
import com.naidiuk.entity.Product;
import com.naidiuk.entity.ProductType;
import com.naidiuk.error.ClientNotFoundException;
import com.naidiuk.mock_dao.MockDaoImplementation;
import com.naidiuk.mock_dao.MockDaoService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClientImplementation implements ClientService {
    private final MockDaoService mockDaoService = new MockDaoImplementation();

    @Override
    public boolean addProduct(int clientId, Product product) {
        Client client = findClientById(clientId);
        if (client.getAge() >= 18 || product.getProductType() != ProductType.ALCOHOL) {
            return client.getProducts().add(product);
        }
        return false;
    }

    @Override
    public List<Product> getAllClientAddedProducts(int clientId) {
        Client client = findClientById(clientId);
        return client.getProducts();
    }

    @Override
    public List<Product> sortProductsByManufacturedDateInAscending() {
        Comparator<Product> sortByManufacturedDateInAscendingComparator =
                (currentProduct, nextProduct) ->
                        currentProduct.getManufacturedDate().compareTo(nextProduct.getManufacturedDate());
        return sortedProductsList(sortByManufacturedDateInAscendingComparator);
    }

    @Override
    public List<Product> sortProductsByManufacturedDateInDescending() {
        Comparator<Product> sortByManufacturedDateInDescendingComparator =
                (currentProduct, nextProduct) ->
                        nextProduct.getManufacturedDate().compareTo(currentProduct.getManufacturedDate());
        return sortedProductsList(sortByManufacturedDateInDescendingComparator);
    }

    @Override
    public List<Product> sortProductsByExpirationDateInAscending() {
        Comparator<Product> sortByExpirationDateInAscendingComparator =
                (currentProduct, nextProduct) ->
                        currentProduct.getExpirationDate().compareTo(nextProduct.getExpirationDate());
        return sortedProductsList(sortByExpirationDateInAscendingComparator);
    }

    @Override
    public List<Product> sortProductsByExpirationDateInDescending() {
        Comparator<Product> sortByExpirationDateInDescendingComparator =
                (currentProduct, nextProduct) ->
                        nextProduct.getExpirationDate().compareTo(currentProduct.getExpirationDate());
        return sortedProductsList(sortByExpirationDateInDescendingComparator);
    }

    @Override
    public List<Product> sortProductsByProductType() {
        Comparator<Product> sortProductsByProductTypeComparator =
                (currentProduct, nextProduct) ->
                        currentProduct.getProductType().compareTo(nextProduct.getProductType());
        return sortedProductsList(sortProductsByProductTypeComparator);
    }

    @Override
    public void updateClientInformation(Client updatedClient) {
        Client client = findClientById(updatedClient.getId());
        client.setName(updatedClient.getName());
        client.setSurname(updatedClient.getSurname());
        client.setAge(updatedClient.getAge());
        client.setDateOfBirth(updatedClient.getDateOfBirth());
        client.setCardNumber(updatedClient.getCardNumber());
        client.setCardBalance(updatedClient.getCardBalance());
        client.setProducts(updatedClient.getProducts());
    }

    @Override
    public boolean deleteOneClientProduct(int clientId, Product product) {
        Client client = findClientById(clientId);
        return client.getProducts().remove(product);
    }

    @Override
    public void deleteAllClientProducts(int clientId) {
        Client client = findClientById(clientId);
        client.getProducts().clear();
    }

    @Override
    public List<Product> getProductsThatClientCanBuyBasedOnHisCardBalance(int clientId) {
        Client client = findClientById(clientId);
        List<Product> availableProductsList = new ArrayList<>();
        List<Product> productsList = getAllProducts();
        for (Product product : productsList) {
            if (client.getCardBalance() >= product.getPrice()) {
                availableProductsList.add(product);
            }
        }
        return availableProductsList;
    }

    @Override
    public List<Client> getAllClients() {
        return mockDaoService.getClientsList();
    }

    @Override
    public List<Product> getAllProducts() {
        return mockDaoService.getProductsList();
    }

    @Override
    public List<Product> getAllProductsWithProductType(ProductType productType) {
        List<Product> productsListWithProductType = new ArrayList<>();
        List<Product> productsList = getAllProducts();
        for (Product product : productsList) {
            if (product.getProductType() == productType) {
                productsListWithProductType.add(product);
            }
        }
        return productsListWithProductType;
    }

    @Override
    public List<Client> getAllClientsOverEighteen() {
        List<Client> clientsOverEighteen = new ArrayList<>();
        List<Client> clientsList = getAllClients();
        for (Client client : clientsList) {
            if (client.getAge() > 18) {
                clientsOverEighteen.add(client);
            }
        }
        return clientsOverEighteen;
    }

    @Override
    public List<Client> getAllClientsWithOneOrMoreProduct() {
        List<Client> clientsWithOneOrMoreProduct = new ArrayList<>();
        List<Client> clientsList = getAllClients();
        for (Client client : clientsList) {
            if (client.getProducts().size() > 0) {
                clientsWithOneOrMoreProduct.add(client);
            }
        }
        return clientsWithOneOrMoreProduct;
    }

    @Override
    public List<Client> getAllClientsWithAlcoholProductType() {
        List<Client> clientsWithAlcohol = new ArrayList<>();
        List<Client> clientsList = getAllClients();
        for (Client client : clientsList) {
            for (Product clientProduct : client.getProducts()) {
                if (clientProduct.getProductType() == ProductType.ALCOHOL) {
                    clientsWithAlcohol.add(client);
                    break;
                }
            }
        }
        return clientsWithAlcohol;
    }

    private Client findClientById(int clientId) {
        for (Client client : mockDaoService.getClientsList()) {
            if (client.getId() == clientId) {
                return client;
            }
        }
        throw new ClientNotFoundException("Client with this id=" + clientId + " not found!");
    }

    private List<Product> sortedProductsList(Comparator<Product> productComparator) {
        List<Product> products = mockDaoService.getProductsList();
        products.sort(productComparator);
        return products;
    }
}
