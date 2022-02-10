package com.naidiuk.service;

import com.naidiuk.entity.Client;
import com.naidiuk.entity.Product;
import com.naidiuk.entity.ProductType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientServiceTest {
    private final ClientService clientService = new ClientImplementation();

    private Client firstClient, secondClient, thirdClient;
    private Product beer, cognac, seabass, salmon, plotva;

    @BeforeEach
    void setUp() {
        List<Client> clients = clientService.getAllClients();
        firstClient = clients.get(0);
        secondClient = clients.get(1);
        thirdClient = clients.get(2);

        List<Product> products = clientService.getAllProducts();
        beer = products.get(1);
        cognac = products.get(5);
        seabass = products.get(7);
        salmon = products.get(8);
        plotva = products.get(9);
    }

    @Test
    void testAddProduct() {
        //prepare
        boolean alcoholAdded;
        boolean productAdded;

        //when
        alcoholAdded = clientService.addProduct(secondClient.getId(), beer);
        productAdded = clientService.addProduct(secondClient.getId(), salmon);
        List<Product> secondClientProducts = clientService.getAllClientAddedProducts(secondClient.getId());

        //then
        assertFalse(alcoholAdded);
        assertTrue(productAdded);
        assertEquals(1, secondClientProducts.size());
    }

    @Test
    void getAllClientAddedProducts() {
        //prepare
        List<Product> thirdClientProducts;

        //when
        clientService.addProduct(thirdClient.getId(), beer);
        clientService.addProduct(thirdClient.getId(), plotva);
        thirdClientProducts = clientService.getAllClientAddedProducts(thirdClient.getId());

        //then
        assertEquals(2, thirdClientProducts.size());
    }

    @Test
    void sortProductsByManufacturedDateInAscending() {
        //prepare
        Product firstManufactured = clientService.getAllProducts().get(2);
        Product secondManufactured = clientService.getAllProducts().get(1);
        Product lastManufactured = clientService.getAllProducts().get(14);

        //when
        List<Product> sortedList = clientService.sortProductsByManufacturedDateInAscending();
        Product firstInSortedList = sortedList.get(0);
        Product secondInSortedList = sortedList.get(1);
        Product lastInSortedList = sortedList.get(14);

        //then
        assertEquals(firstManufactured, firstInSortedList);
        assertEquals(secondManufactured, secondInSortedList);
        assertEquals(lastManufactured, lastInSortedList);
    }

    @Test
    void sortProductsByManufacturedDateInDescending() {
        //prepare
        Product lastManufactured = clientService.getAllProducts().get(14);
        Product preLastManufactured = clientService.getAllProducts().get(12);
        Product firstManufactured = clientService.getAllProducts().get(2);

        //when
        List<Product> sortedList = clientService.sortProductsByManufacturedDateInDescending();
        Product firstInSortedList = sortedList.get(0);
        Product secondInSortedList = sortedList.get(1);
        Product lastInSortedList = sortedList.get(14);

        //then
        assertEquals(lastManufactured, firstInSortedList);
        assertEquals(preLastManufactured, secondInSortedList);
        assertEquals(firstManufactured, lastInSortedList);
    }

    @Test
    void sortProductsByExpirationDateInAscending() {
        //prepare
        Product firstExpiration = clientService.getAllProducts().get(11);
        Product secondExpiration = clientService.getAllProducts().get(13);
        Product lastExpiration = clientService.getAllProducts().get(5);

        //when
        List<Product> sortedList = clientService.sortProductsByExpirationDateInAscending();
        Product firstInSortedList = sortedList.get(0);
        Product secondInSortedList = sortedList.get(1);
        Product lastInSortedList = sortedList.get(14);

        //then
        assertEquals(firstExpiration, firstInSortedList);
        assertEquals(secondExpiration, secondInSortedList);
        assertEquals(lastExpiration, lastInSortedList);
    }

    @Test
    void sortProductsByExpirationDateInDescending() {
        //prepare
        Product lastExpiration = clientService.getAllProducts().get(5);
        Product preLastExpiration = clientService.getAllProducts().get(2);
        Product firstExpiration = clientService.getAllProducts().get(11);

        //when
        List<Product> sortedList = clientService.sortProductsByExpirationDateInDescending();
        Product firstInSortedList = sortedList.get(0);
        Product secondInSortedList = sortedList.get(1);
        Product lastInSortedList = sortedList.get(14);

        //then
        assertEquals(lastExpiration, firstInSortedList);
        assertEquals(preLastExpiration, secondInSortedList);
        assertEquals(firstExpiration, lastInSortedList);
    }

    @Test
    void sortProductsByProductType() {
        //prepare
        ProductType firstType = clientService.getAllProducts().get(0).getProductType();
        ProductType secondType = clientService.getAllProducts().get(6).getProductType();
        ProductType lastType = clientService.getAllProducts().get(14).getProductType();

        //when
        List<Product> sortedList = clientService.sortProductsByProductType();
        ProductType firstTypeInSortedList = sortedList.get(0).getProductType();
        ProductType secondTypeInSortedList = sortedList.get(6).getProductType();
        ProductType lastTypeInSortedList = sortedList.get(14).getProductType();

        //then
        assertEquals(firstType, firstTypeInSortedList);
        assertEquals(secondType, secondTypeInSortedList);
        assertEquals(lastType, lastTypeInSortedList);
    }

    @Test
    void updateClientInformation() {
        //prepare
        Client updatedClient = new Client();
        updatedClient.setId(1);
        updatedClient.setName("Dikiy");
        updatedClient.setSurname("Demon");
        updatedClient.setAge(11);
        updatedClient.setCardNumber("3224 3318 5792 1111");
        updatedClient.setCardBalance(322.11);

        //when
        clientService.updateClientInformation(updatedClient);
        Client firstClientAfterUpdate = clientService.getAllClients().get(0);

        //then
        assertEquals(updatedClient, firstClientAfterUpdate);
    }

    @Test
    void deleteOneClientProduct() {
        //prepare
        boolean productDeleted;
        boolean productDeletedAfterAdded;

        //when
        productDeleted = clientService.deleteOneClientProduct(firstClient.getId(), plotva);
        clientService.addProduct(firstClient.getId(), plotva);
        productDeletedAfterAdded = clientService.deleteOneClientProduct(firstClient.getId(), plotva);

        //then
        assertFalse(productDeleted);
        assertTrue(productDeletedAfterAdded);
    }

    @Test
    void deleteAllClientProducts() {
        //prepare
        clientService.addProduct(thirdClient.getId(), cognac);
        clientService.addProduct(thirdClient.getId(), seabass);

        //when
        clientService.deleteAllClientProducts(thirdClient.getId());
        int clientProductsCountAfterDeletion = clientService.getAllClientAddedProducts(thirdClient.getId()).size();

        //then
        assertEquals(0, clientProductsCountAfterDeletion);
    }

    @Test
    void getProductsThatClientCanBuyBasedOnHisCardBalance() {
        //prepare
        List<Product> availableProducts;

        //when
        availableProducts = clientService.getProductsThatClientCanBuyBasedOnHisCardBalance(secondClient.getId());

        //then
        assertEquals(4, availableProducts.size());
    }

    @Test
    void testGetAllClients() {
        //prepare
        List<Client> clientsList;

        //when
        clientsList = clientService.getAllClients();

        //then
        assertEquals(3, clientsList.size());
    }

    @Test
    void getAllProducts() {
        //prepare
        List<Product> products;

        //when
        products = clientService.getAllProducts();

        //then
        assertEquals(15, products.size());
    }

    @Test
    void getAllProductsWithProductType() {
        //prepare
        List<Product> productsWithFishType;

        //when
        productsWithFishType = clientService.getAllProductsWithProductType(ProductType.FISH);

        //then
        assertEquals(5, productsWithFishType.size());
    }

    @Test
    void getAllClientsOverEighteen() {
        //prepare
        List<Client> clientsOverEighteen;

        //when
        clientsOverEighteen = clientService.getAllClientsOverEighteen();

        //then
        assertEquals(2, clientsOverEighteen.size());
    }

    @Test
    void getAllClientsWithOneOrMoreProduct() {
        //prepare
        clientService.addProduct(firstClient.getId(), beer);
        clientService.addProduct(firstClient.getId(), cognac);
        clientService.addProduct(firstClient.getId(), plotva);

        clientService.addProduct(secondClient.getId(), seabass);

        //when
        List<Client> clientsWithOneOrMoreProduct = clientService.getAllClientsWithOneOrMoreProduct();

        //then
        assertEquals(2, clientsWithOneOrMoreProduct.size());
    }

    @Test
    void getAllClientsWithAlcoholProductType() {
        //prepare
        clientService.addProduct(firstClient.getId(), beer);
        clientService.addProduct(firstClient.getId(), plotva);

        clientService.addProduct(thirdClient.getId(), cognac);

        //when
        List<Client> clientsWithAlcohol = clientService.getAllClientsWithAlcoholProductType();

        //then
        assertEquals(2, clientsWithAlcohol.size());
    }
}