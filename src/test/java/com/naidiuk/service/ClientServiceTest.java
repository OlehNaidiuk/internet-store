package com.naidiuk.service;

import com.naidiuk.entity.Client;
import com.naidiuk.entity.Product;
import com.naidiuk.entity.ProductType;
import com.naidiuk.mock_dao.MockDaoImplementation;
import com.naidiuk.mock_dao.MockDaoService;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientServiceTest {
    private final MockDaoService mockDaoService = new MockDaoImplementation();
    private final ClientService clientService = new ClientCapabilities();

    private final Client neo = mockDaoService.getClientsList().get(0);
    private final Client keanu = mockDaoService.getClientsList().get(1);
    private final Client agentSmith = mockDaoService.getClientsList().get(2);

    private final Product beer = mockDaoService.getProductsList().get(1);
    private final Product cognac = mockDaoService.getProductsList().get(5);
    private final Product plotva = mockDaoService.getProductsList().get(9);
    private final Product seabass = mockDaoService.getProductsList().get(7);
    private final Product salmon = mockDaoService.getProductsList().get(8);

    @Test
    void testGetAllClients() {
        //prepare
        List<Client> mockDaoClientsList = mockDaoService.getClientsList();

        //when
        List<Client> serviceClientsList = clientService.getAllClients();

        //then
        assertEquals(mockDaoClientsList, serviceClientsList);
    }

    @Test
    void testGetAllClientsOverEighteen() {
        //prepare
        List<Client> mockDaoClientsListOverEighteen = new ArrayList<>();
        mockDaoClientsListOverEighteen.add(neo);
        mockDaoClientsListOverEighteen.add(agentSmith);

        //when
        List<Client> serviceClientsListOverEighteen = clientService.getAllClientsOverEighteen();

        //then
        assertEquals(mockDaoClientsListOverEighteen, serviceClientsListOverEighteen);
    }

    @Test
    void testGetAllClientsWithOneOrMoreProduct() {
        //prepare
        List<Product> neoProducts = neo.getProducts();
        neoProducts.add(beer);
        neoProducts.add(cognac);

        List<Product> keanuProducts = keanu.getProducts();
        keanuProducts.add(plotva);

        List<Client> mockDaoClientsWithOneOrMoreProduct = new ArrayList<>();
        mockDaoClientsWithOneOrMoreProduct.add(neo);
        mockDaoClientsWithOneOrMoreProduct.add(keanu);

        //when
        clientService.addProduct(neo.getId(), beer);
        clientService.addProduct(neo.getId(), cognac);

        clientService.addProduct(keanu.getId(), plotva);

        List<Client> serviceClientsWithOneOrMoreProduct = clientService.getAllClientsWithOneOrMoreProduct();

        //then
        assertEquals(mockDaoClientsWithOneOrMoreProduct, serviceClientsWithOneOrMoreProduct);
    }

    @Test
    void testGetAllClientsWithAlcoholProductType() {
        //prepare
        List<Product> neoProducts = neo.getProducts();
        neoProducts.add(beer);
        neoProducts.add(cognac);

        List<Product> keanuProducts = keanu.getProducts();
        keanuProducts.add(plotva);

        List<Product> agentSmithProducts = agentSmith.getProducts();
        agentSmithProducts.add(seabass);
        agentSmithProducts.add(salmon);

        List<Client> mockDaoClientsWithAlcoholProductType = new ArrayList<>();
        mockDaoClientsWithAlcoholProductType.add(neo);

        //when
        clientService.addProduct(neo.getId(), beer);
        clientService.addProduct(neo.getId(), cognac);

        clientService.addProduct(keanu.getId(), plotva);

        clientService.addProduct(agentSmith.getId(), seabass);
        clientService.addProduct(agentSmith.getId(), salmon);

        List<Client> serviceClientsWithAlcoholProductType = clientService.getAllClientsWithAlcoholProductType();

        //then
        assertEquals(mockDaoClientsWithAlcoholProductType, serviceClientsWithAlcoholProductType);
    }

    @Test
    void testGetAllProducts() {
        //prepare
        List<Product> mockDaoProductsList = mockDaoService.getProductsList();

        //when
        List<Product> serviceProductsList = clientService.getAllProducts();

        //then
        assertEquals(mockDaoProductsList, serviceProductsList);
    }

    @Test
    void testGetAllClientAddedProducts() {
        //prepare
        List<Product> neoProducts = neo.getProducts();
        neoProducts.add(beer);
        neoProducts.add(cognac);

        List<Product> keanuProducts = keanu.getProducts();
        keanuProducts.add(plotva);

        List<Product> agentSmithProducts = agentSmith.getProducts();
        agentSmithProducts.add(seabass);
        agentSmithProducts.add(salmon);

        //when
        clientService.addProduct(neo.getId(), beer);
        clientService.addProduct(neo.getId(), cognac);

        clientService.addProduct(keanu.getId(), plotva);

        clientService.addProduct(agentSmith.getId(), seabass);
        clientService.addProduct(agentSmith.getId(), salmon);

        List<Product> neoAddedProducts = clientService.getAllClientAddedProducts(neo.getId());
        List<Product> keanuAddedProducts = clientService.getAllClientAddedProducts(keanu.getId());
        List<Product> agentSmithAddedProducts = clientService.getAllClientAddedProducts(agentSmith.getId());

        //then
        assertEquals(neoProducts, neoAddedProducts);
        assertEquals(keanuProducts, keanuAddedProducts);
        assertEquals(agentSmithProducts, agentSmithAddedProducts);
    }

    @Test
    void testGetProductsThatClientCanBuyBasedOnHisCardBalance() {
        //prepare
        List<Product> mockDaoProducts = mockDaoService.getProductsList();

        //when
        List<Product> productsThatNeoCanBuy = clientService.getProductsThatClientCanBuyBasedOnHisCardBalance(neo.getId());

        //then
        assertEquals(mockDaoProducts, productsThatNeoCanBuy);
    }

    @Test
    void testSortProductsByManufacturedDateInAscending() {
        //prepare
        LocalDateTime first = mockDaoService.getProductsList().get(2).getManufacturedDate();
        LocalDateTime second = mockDaoService.getProductsList().get(1).getManufacturedDate();
        LocalDateTime last = mockDaoService.getProductsList().get(14).getManufacturedDate();

        //when
        List<Product> serviceSortedList = clientService.sortProductsByManufacturedDateInAscending();

        //then
        assertEquals(first, serviceSortedList.get(0).getManufacturedDate());
        assertEquals(second, serviceSortedList.get(1).getManufacturedDate());
        assertEquals(last, serviceSortedList.get(14).getManufacturedDate());
    }

    @Test
    void testSortProductsByManufacturedDateInDescending() {
        //prepare
        LocalDateTime first = mockDaoService.getProductsList().get(14).getManufacturedDate();
        LocalDateTime second = mockDaoService.getProductsList().get(12).getManufacturedDate();
        LocalDateTime last = mockDaoService.getProductsList().get(2).getManufacturedDate();

        //when
        List<Product> serviceSortedList = clientService.sortProductsByManufacturedDateInDescending();

        //then
        assertEquals(first, serviceSortedList.get(0).getManufacturedDate());
        assertEquals(second, serviceSortedList.get(1).getManufacturedDate());
        assertEquals(last, serviceSortedList.get(14).getManufacturedDate());
    }

    @Test
    void testSortProductsByExpirationDateInAscending() {
        //prepare
        LocalDateTime first = mockDaoService.getProductsList().get(11).getExpirationDate();
        LocalDateTime second = mockDaoService.getProductsList().get(13).getExpirationDate();
        LocalDateTime last = mockDaoService.getProductsList().get(5).getExpirationDate();

        //when
        List<Product> serviceSortedList = clientService.sortProductsByExpirationDateInAscending();

        //then
        assertEquals(first, serviceSortedList.get(0).getExpirationDate());
        assertEquals(second, serviceSortedList.get(1).getExpirationDate());
        assertEquals(last, serviceSortedList.get(14).getExpirationDate());
    }

    @Test
    void testSortProductsByExpirationDateInDescending() {
        //prepare
        LocalDateTime first = mockDaoService.getProductsList().get(5).getExpirationDate();
        LocalDateTime second = mockDaoService.getProductsList().get(2).getExpirationDate();
        LocalDateTime last = mockDaoService.getProductsList().get(11).getExpirationDate();

        //when
        List<Product> serviceSortedList = clientService.sortProductsByExpirationDateInDescending();

        //then
        assertEquals(first, serviceSortedList.get(0).getExpirationDate());
        assertEquals(second, serviceSortedList.get(1).getExpirationDate());
        assertEquals(last, serviceSortedList.get(14).getExpirationDate());
    }

    @Test
    void testsSortProductsByProductType() {
        //prepare
        ProductType first = mockDaoService.getProductsList().get(0).getProductType();
        ProductType second = mockDaoService.getProductsList().get(1).getProductType();
        ProductType last = mockDaoService.getProductsList().get(14).getProductType();

        //when
        List<Product> serviceSortedList = clientService.sortProductsByProductType();

        //then
        assertEquals(first, serviceSortedList.get(0).getProductType());
        assertEquals(second, serviceSortedList.get(1).getProductType());
        assertEquals(last, serviceSortedList.get(14).getProductType());
    }

    @Test
    void testGetAllProductsWithProductType() {
        //prepare
        List<Product> productsWithFishProductType = new ArrayList<>(5);
        productsWithFishProductType.add(mockDaoService.getProductsList().get(6));
        productsWithFishProductType.add(mockDaoService.getProductsList().get(7));
        productsWithFishProductType.add(mockDaoService.getProductsList().get(8));
        productsWithFishProductType.add(mockDaoService.getProductsList().get(9));
        productsWithFishProductType.add(mockDaoService.getProductsList().get(10));

        //when
        List<Product> serviceProductsWithFish = clientService.getAllProductsWithProductType(ProductType.FISH);

        //then
        assertEquals(productsWithFishProductType, serviceProductsWithFish);
    }

    @Test
    void testAddProduct() {
        //prepare
        //age = 17
        clientService.addProduct(keanu.getId(), beer);    //alcohol
        clientService.addProduct(keanu.getId(), cognac);  //alcohol
        clientService.addProduct(keanu.getId(), salmon);
        clientService.addProduct(keanu.getId(), seabass);

        //when
        List<Product> keanuProducts = clientService.getAllClientAddedProducts(keanu.getId());

        //then
        assertEquals(2, keanuProducts.size());
    }

    @Test
    void testDeleteOneClientProduct() {
        //prepare
        //age = 17
        clientService.addProduct(keanu.getId(), beer);    //alcohol
        clientService.addProduct(keanu.getId(), cognac);  //alcohol
        clientService.addProduct(keanu.getId(), salmon);
        clientService.addProduct(keanu.getId(), seabass);

        //when
        clientService.deleteOneClientProduct(keanu.getId(), salmon);
        List<Product> keanuProducts = clientService.getAllClientAddedProducts(keanu.getId());

        //then
        assertEquals(1, keanuProducts.size());
    }

    @Test
    void testDeleteAllClientProducts() {
        //prepare
        //age = 17
        clientService.addProduct(keanu.getId(), beer);    //alcohol
        clientService.addProduct(keanu.getId(), cognac);  //alcohol
        clientService.addProduct(keanu.getId(), salmon);
        clientService.addProduct(keanu.getId(), seabass);

        //when
        clientService.deleteAllClientProducts(keanu.getId());
        List<Product> keanuProducts = clientService.getAllClientAddedProducts(keanu.getId());

        //then
        assertEquals(0, keanuProducts.size());
    }

    @Test
    void testUpdateClientInformation() {
        //prepare
        Client updatedClient = new Client();
        updatedClient.setId(1);
        updatedClient.setName("Dikiy");
        updatedClient.setSurname("Demon");
        updatedClient.setAge(11);
        updatedClient.setCardNumber("3224 3318 5792 1111");
        updatedClient.setCardBalance(322.11);

        //when
        Client beforeUpdate = neo;
        clientService.updateClientInformation(updatedClient);
        Client afterUpdate = clientService.getAllClients().get(0);

        //then
        assertEquals("Thomas", beforeUpdate.getName());
        assertEquals("Dikiy", afterUpdate.getName());
    }
}