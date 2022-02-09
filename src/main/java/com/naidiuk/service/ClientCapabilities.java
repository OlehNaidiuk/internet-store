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

public class ClientCapabilities implements ClientService {
    private final MockDaoService mockDaoService = new MockDaoImplementation();

    @Override
    public void addProduct(int clientId, Product product) {
        Client client = findClientById(clientId);
        if (product.getProductType() == ProductType.ALCOHOL) {
            if (client.getAge() >= 18) {
                client.getProducts().add(product);
            }
        } else {
            client.getProducts().add(product);
        }
    }

    @Override
    public List<Product> getAllAddedProducts(int clientId) {
        Client client = findClientById(clientId);
        return client.getProducts();

    }

    @Override
    public List<Product> sortProductsByManufacturedDateInAscending() {
        Comparator<Product> sortByManufacturedDateInAscendingComparator =
                (o1, o2) -> o1.getManufacturedDate().compareTo(o2.getManufacturedDate());
        return sortedProductsList(sortByManufacturedDateInAscendingComparator);
    }

    @Override
    public List<Product> sortProductsByManufacturedDateInDescending() {
        Comparator<Product> sortByManufacturedDateInDescendingComparator =
                (o1, o2) -> o2.getManufacturedDate().compareTo(o1.getManufacturedDate());
        return sortedProductsList(sortByManufacturedDateInDescendingComparator);
    }

    @Override
    public List<Product> sortProductsByExpirationDateInAscending() {
        Comparator<Product> sortByExpirationDateInAscendingComparator =
                (o1, o2) -> o1.getExpirationDate().compareTo(o2.getExpirationDate());
        return sortedProductsList(sortByExpirationDateInAscendingComparator);
    }

    @Override
    public List<Product> sortProductsByExpirationDateInDescending() {
        Comparator<Product> sortByExpirationDateInDescendingComparator =
                (o1, o2) -> o2.getExpirationDate().compareTo(o1.getExpirationDate());
        return sortedProductsList(sortByExpirationDateInDescendingComparator);
    }

    @Override
    public List<Product> sortProductsByProductType() {
        Comparator<Product> sortProductsByProductTypeComparator =
                (o1, o2) -> o1.getProductType().compareTo(o2.getProductType());
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
    public void deleteOneClientProduct(int clientId, Product product) {
        Client client = findClientById(clientId);
        client.getProducts().remove(product);
    }

    @Override
    public void deleteAllClientProducts(int clientId) {
        Client client = findClientById(clientId);
        client.getProducts().clear();
    }

    @Override
    public List<Product> showProductsThatClientCanBuyBasedOnHisCardBalance(int clientId) {
        Client client = findClientById(clientId);
        List<Product> availableProductsList = new ArrayList<>();
        if (client.getProducts().isEmpty()) {
            for (Product product : mockDaoService.getProductsList()) {
                if (client.getCardBalance() >= product.getPrice()) {
                    availableProductsList.add(product);
                }
            }
        } else {
            double checkAmount = 0.0;
            for (Product clientProduct : client.getProducts()) {
                checkAmount += clientProduct.getPrice();
            }
            double remainingBalance = client.getCardBalance() - checkAmount;
            for (Product product : mockDaoService.getProductsList()) {
                if (remainingBalance >= product.getPrice()) {
                    availableProductsList.add(product);
                }
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
    public List<Product> getAllProductsWithProductType() {
        Comparator<Product> sortByProductType =
                (o1, o2) -> o1.getProductType().compareTo(o2.getProductType());
        return sortedProductsList(sortByProductType);
    }

    @Override
    public List<Client> getAllClientsOverEighteen() {
        List<Client> clientsOverEighteen = new ArrayList<>();
        for (Client client : mockDaoService.getClientsList()) {
            if (client.getAge() >= 18) {
                clientsOverEighteen.add(client);
            }
        }
        return clientsOverEighteen;
    }

    @Override
    public List<Client> getAllClientsWithOneOrMoreProduct() {
        List<Client> clientsWithOneOrMoreProduct = new ArrayList<>();
        for (Client client : mockDaoService.getClientsList()) {
            if (client.getProducts().size() > 0) {
                clientsWithOneOrMoreProduct.add(client);
            }
        }
        return clientsWithOneOrMoreProduct;
    }

    @Override
    public List<Client> getAllClientsWithAlcoholProductType() {
        List<Client> clientsWithAlcohol = new ArrayList<>();
        for (Client client : mockDaoService.getClientsList()) {
            for (Product clientProduct : client.getProducts()) {
                if (clientProduct.getProductType() == ProductType.ALCOHOL) {
                    clientsWithAlcohol.add(client);
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
        throw new ClientNotFoundException("Client with this id not found!");
    }

    private List<Product> sortedProductsList(Comparator<Product> productComparator) {
        List<Product> products = mockDaoService.getProductsList();
        products.sort(productComparator);
        return products;
    }
}
