package com.naidiuk.service;

import com.naidiuk.entity.Client;
import com.naidiuk.entity.Product;
import com.naidiuk.entity.ProductType;
import com.naidiuk.mock_dao.Data;
import com.naidiuk.mock_dao.DataService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClientService {
    private final DataService dataService = new Data();
    private List<Client> clientsList;

    public void addProduct(Client client, Product product) {
        checkClientsList();
        if (clientsList.contains(client)) {
            int index = clientsList.indexOf(client);
            if (product.getProductType() == ProductType.ALCOHOL && client.getAge() >= 18) {
                client.getProducts().add(product);
            } else {
                client.getProducts().add(product);
            }
            clientsList.set(index, client);
        } else {
            throw new RuntimeException("Client not found!");
        }
    }

    public List<Product> getAllAddedProducts(Client client) {
        checkClientsList();
        if (clientsList.contains(client)) {
            return client.getProducts();
        }
        throw new RuntimeException("Client not found!");
    }

    public List<Product> sortProductsByManufacturedDateInAscending() {
        Comparator<Product> sortByManufacturedDateInAscendingComparator =
                (o1, o2) -> o1.getManufacturedDate().compareTo(o2.getManufacturedDate());
        List<Product> products = dataService.getProductsList();
        products.sort(sortByManufacturedDateInAscendingComparator);
        return products;
    }

    public List<Product> sortProductsByManufacturedDateInDescending() {
        Comparator<Product> sortByManufacturedDateInDescendingComparator =
                (o1, o2) -> o2.getManufacturedDate().compareTo(o1.getManufacturedDate());
        List<Product> products = dataService.getProductsList();
        products.sort(sortByManufacturedDateInDescendingComparator);
        return products;
    }

    public List<Product> sortProductsByExpirationDateInAscending() {
        Comparator<Product> sortByExpirationDateInAscendingComparator =
                (o1, o2) -> o1.getExpirationDate().compareTo(o2.getExpirationDate());
        List<Product> products = dataService.getProductsList();
        products.sort(sortByExpirationDateInAscendingComparator);
        return products;
    }

    public List<Product> sortProductsByExpirationDateInDescending() {
        Comparator<Product> sortByExpirationDateInDescendingComparator =
                (o1, o2) -> o2.getExpirationDate().compareTo(o1.getExpirationDate());
        List<Product> products = dataService.getProductsList();
        products.sort(sortByExpirationDateInDescendingComparator);
        return products;
    }

    public List<Product> sortProductsByProductType() {
        Comparator<Product> sortProductsByProductTypeComparator =
                (o1, o2) -> o1.getProductType().compareTo(o2.getProductType());
        List<Product> products = dataService.getProductsList();
        products.sort(sortProductsByProductTypeComparator);
        return products;
    }

    public void updateClientInformation(Client updatedClient) {
        checkClientsList();
        Client desiredClient = null;
        int index = 0;
        for (int i = 0; i < clientsList.size(); i++) {
            Client client = clientsList.get(i);
            if (client.getId() == updatedClient.getId()) {
                desiredClient = client;
                index = i;
            }
        }
        if (desiredClient == null) {
            throw new RuntimeException("Client for update not found!");
        } else {
            desiredClient.setName(updatedClient.getName());
            desiredClient.setSurname(updatedClient.getSurname());
            desiredClient.setAge(updatedClient.getAge());
            desiredClient.setDateOfBirth(updatedClient.getDateOfBirth());
            desiredClient.setCardNumber(updatedClient.getCardNumber());
            desiredClient.setCardBalance(updatedClient.getCardBalance());
            desiredClient.setProducts(updatedClient.getProducts());
            clientsList.set(index, desiredClient);
        }
    }

    public void deleteOneClientProduct(Client client, Product product) {
        checkClientsList();
        if (clientsList.contains(client)) {
            int index = clientsList.indexOf(client);
            client.getProducts().remove(product);
            clientsList.set(index, client);
        } else {
            throw new RuntimeException("Client not found!");
        }
    }

    public void deleteAllClientProducts(Client client) {
        checkClientsList();
        if (clientsList.contains(client)) {
            int index = clientsList.indexOf(client);
            client.getProducts().clear();
            clientsList.set(index, client);
        } else {
            throw new RuntimeException("Client not found!");
        }
    }

    public List<Product> showProductsThatClientCanBuyBasedOnHisCardBalance(Client client) {
        checkClientsList();
        if (clientsList.contains(client)) {
            List<Product> availableProductsList = new ArrayList<>();
            if (client.getProducts().isEmpty()) {
                for (Product product : dataService.getProductsList()) {
                    if (client.getCardBalance() >= product.getPrice()) {
                        availableProductsList.add(product);
                    }
                }
            } else {
                double checkAmount = 0.0;
                for (Product clientProduct : client.getProducts()) {
                    checkAmount += clientProduct.getPrice();
                }
                for (Product product : dataService.getProductsList()) {
                    if ((client.getCardBalance() - checkAmount) >= product.getPrice()) {
                        availableProductsList.add(product);
                    }
                }
            }
            return availableProductsList;
        } else {
            throw new RuntimeException("Client not found!");
        }
    }

    public List<Client> getAllClients() {
        checkClientsList();
        return clientsList;
    }

    public List<Product> getAllProducts() {
        return dataService.getProductsList();
    }

    public List<Product> getAllProductsWithProductType() {
        Comparator<Product> sortByProductType =
                (o1, o2) -> o1.getProductType().compareTo(o2.getProductType());
        List<Product> products = dataService.getProductsList();
        products.sort(sortByProductType);
        return products;
    }

    public List<Client> getAllClientsOverEighteen() {
        checkClientsList();
        List<Client> clientsOverEighteen = new ArrayList<>();
        for (Client client : clientsList) {
            if (client.getAge() >=18) {
                clientsOverEighteen.add(client);
            }
        }
        return clientsOverEighteen;
    }

    public List<Client> getAllClientsWithOneOrMoreProduct() {
        checkClientsList();
        List<Client> clientsWithOneOrMoreProduct = new ArrayList<>();
        for (Client client : clientsList) {
            if (client.getProducts().size() > 0) {
                clientsWithOneOrMoreProduct.add(client);
            }
        }
        return clientsWithOneOrMoreProduct;
    }

    public List<Client> getAllClientsWithAlcoholProductType() {
        checkClientsList();
        List<Client> clientsWithAlcohol = new ArrayList<>();
        for (Client client : clientsList) {
            for (Product clientProduct : client.getProducts()) {
                if (clientProduct.getProductType() == ProductType.ALCOHOL) {
                    clientsWithAlcohol.add(client);
                }
            }
        }
        return clientsWithAlcohol;
    }

    private void checkClientsList() {
        if (clientsList == null) {
            clientsList = dataService.getClientsList();
        }
    }
}
