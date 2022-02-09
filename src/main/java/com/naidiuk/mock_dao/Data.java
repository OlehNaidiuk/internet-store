package com.naidiuk.mock_dao;

import com.naidiuk.entity.Client;
import com.naidiuk.entity.Product;
import com.naidiuk.entity.ProductType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Data implements DataService {
    private List<Client> clients;
    private List<Client> clientsWithProducts;
    private List<Product> products;

    @Override
    public List<Client> getClientsList() {
        generateClientsList();
        return clients;
    }

    @Override
    public List<Product> getProductsList() {
        generateProductsList();
        return products;
    }

    @Override
    public List<Client> getClientsWithTheirProductsList() {
        generateClientsListWithProductsList();
        return clientsWithProducts;
    }

    private void generateClientsList() {
        Client neo = new Client();
        neo.setId(1);
        neo.setName("Thomas");
        neo.setSurname("Anderson");
        neo.setAge(31);
        neo.setDateOfBirth(LocalDate.of(1990, 6, 4));
        neo.setCardNumber("9916 6898 4945 5470");
        neo.setCardBalance(1983.39);
        neo.setProducts(new ArrayList<>());

        Client keanu = new Client();
        keanu.setId(2);
        keanu.setName("Keanu");
        keanu.setSurname("Reeves");
        keanu.setAge(32);
        keanu.setDateOfBirth(LocalDate.of(1990, 2, 6));
        keanu.setCardNumber("1472 3757 2227 4782");
        keanu.setCardBalance(2707.58);
        keanu.setProducts(new ArrayList<>());

        Client agentSmith = new Client();
        agentSmith.setId(3);
        agentSmith.setName("Agent");
        agentSmith.setSurname("Smith");
        agentSmith.setAge(31);
        agentSmith.setDateOfBirth(LocalDate.of(1990, 5, 31));
        agentSmith.setCardNumber("7892 8993 8572 8538");
        agentSmith.setCardBalance(601.84);
        agentSmith.setProducts(new ArrayList<>());

        clients = new ArrayList<>(3);
        clients.add(neo);
        clients.add(keanu);
        clients.add(agentSmith);
    }

    private void generateProductsList() {
        Product beerStellaArtois = new Product();
        beerStellaArtois.setId(1);
        beerStellaArtois.setName("Stella Artois");
        beerStellaArtois.setProductType(ProductType.ALCOHOL);
        beerStellaArtois.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 45, 38));
        beerStellaArtois.setExpirationDate(LocalDateTime.of(2022, 8, 7, 1, 59, 59));
        beerStellaArtois.setPrice(28.60);
        beerStellaArtois.setDiscount(0.0);

        Product beerHoegaardenBlanche = new Product();
        beerHoegaardenBlanche.setId(2);
        beerHoegaardenBlanche.setName("Hoegaarden Blanche");
        beerHoegaardenBlanche.setProductType(ProductType.ALCOHOL);
        beerHoegaardenBlanche.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 46, 38));
        beerHoegaardenBlanche.setExpirationDate(LocalDateTime.of(2022, 8, 7, 23, 11, 38));
        beerHoegaardenBlanche.setPrice(56.90);
        beerHoegaardenBlanche.setDiscount(0.0);

        Product finlandiaCranberry = new Product();
        finlandiaCranberry.setId(3);
        finlandiaCranberry.setName("Finlandia Cranberry");
        finlandiaCranberry.setProductType(ProductType.ALCOHOL);
        finlandiaCranberry.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 47, 38));
        finlandiaCranberry.setExpirationDate(LocalDateTime.of(2027, 2, 7, 6, 16, 38));
        finlandiaCranberry.setPrice(218.90);
        finlandiaCranberry.setDiscount(0.0);

        Product wineFianno = new Product();
        wineFianno.setId(4);
        wineFianno.setName("Fianno Di Avellino");
        wineFianno.setProductType(ProductType.ALCOHOL);
        wineFianno.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 48, 38));
        wineFianno.setExpirationDate(LocalDateTime.of(2025, 2, 7, 2, 33, 38));
        wineFianno.setPrice(349.90);
        wineFianno.setDiscount(0.0);

        Product winePuebloViejo = new Product();
        winePuebloViejo.setId(5);
        winePuebloViejo.setName("Pueblo Viejo Reserva");
        winePuebloViejo.setProductType(ProductType.ALCOHOL);
        winePuebloViejo.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 49, 38));
        winePuebloViejo.setExpirationDate(LocalDateTime.of(2025, 2, 7, 15, 42, 38));
        winePuebloViejo.setPrice(249.90);
        winePuebloViejo.setDiscount(0.0);

        Product cognacRemyMartin = new Product();
        cognacRemyMartin.setId(6);
        cognacRemyMartin.setName("Remy Martin");
        cognacRemyMartin.setProductType(ProductType.ALCOHOL);
        cognacRemyMartin.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 50, 38));
        cognacRemyMartin.setExpirationDate(LocalDateTime.of(2099, 1, 1, 0, 0, 0));
        cognacRemyMartin.setPrice(2049.99);
        cognacRemyMartin.setDiscount(0.0);

        Product tunaSteak = new Product();
        tunaSteak.setId(7);
        tunaSteak.setName("Tuna Steak");
        tunaSteak.setProductType(ProductType.FISH);
        tunaSteak.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 51, 38));
        tunaSteak.setExpirationDate(LocalDateTime.of(2022, 8, 7, 14, 28, 38));
        tunaSteak.setPrice(979.90);
        tunaSteak.setDiscount(0.0);

        Product seabass = new Product();
        seabass.setId(8);
        seabass.setName("Seabass");
        seabass.setProductType(ProductType.FISH);
        seabass.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 52, 38));
        seabass.setExpirationDate(LocalDateTime.of(2022, 2, 17, 9, 6, 38));
        seabass.setPrice(229.90);
        seabass.setDiscount(0.0);

        Product salmonSteak = new Product();
        salmonSteak.setId(9);
        salmonSteak.setName("Salmon Steak");
        salmonSteak.setProductType(ProductType.FISH);
        salmonSteak.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 53, 38));
        salmonSteak.setExpirationDate(LocalDateTime.of(2022, 2, 17, 5, 25, 38));
        salmonSteak.setPrice(539.90);
        salmonSteak.setDiscount(0.0);

        Product plotva = new Product();
        plotva.setId(10);
        plotva.setName("Plotva");
        plotva.setProductType(ProductType.FISH);
        plotva.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 54, 38));
        plotva.setExpirationDate(LocalDateTime.of(2022, 8, 7, 7, 37, 38));
        plotva.setPrice(249.99);
        plotva.setDiscount(0.0);

        Product sudak = new Product();
        sudak.setId(11);
        sudak.setName("Sudak");
        sudak.setProductType(ProductType.FISH);
        sudak.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 55, 38));
        sudak.setExpirationDate(LocalDateTime.of(2022, 8, 7, 22, 19, 38));
        sudak.setPrice(240.78);
        sudak.setDiscount(0.0);

        Product porkNeck = new Product();
        porkNeck.setId(12);
        porkNeck.setName("Osheek");
        porkNeck.setProductType(ProductType.MEAT);
        porkNeck.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 56, 38));
        porkNeck.setExpirationDate(LocalDateTime.of(2022, 2, 14, 11, 53, 38));
        porkNeck.setPrice(148.99);
        porkNeck.setDiscount(0.0);

        Product porkMinceFresh = new Product();
        porkMinceFresh.setId(13);
        porkMinceFresh.setName("Pork Mince Fresh");
        porkMinceFresh.setProductType(ProductType.MEAT);
        porkMinceFresh.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 57, 38));
        porkMinceFresh.setExpirationDate(LocalDateTime.of(2022, 2, 14, 7, 24, 38));
        porkMinceFresh.setPrice(114.90);
        porkMinceFresh.setDiscount(0.0);

        Product beefEntrecote = new Product();
        beefEntrecote.setId(14);
        beefEntrecote.setName("Beef Entrecote");
        beefEntrecote.setProductType(ProductType.MEAT);
        beefEntrecote.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 58, 38));
        beefEntrecote.setExpirationDate(LocalDateTime.of(2022, 2, 14, 19, 32, 38));
        beefEntrecote.setPrice(1499.00);
        beefEntrecote.setDiscount(0.0);

        Product sausageAlanMoscow = new Product();
        sausageAlanMoscow.setId(15);
        sausageAlanMoscow.setName("Alan Moscow");
        sausageAlanMoscow.setProductType(ProductType.MEAT);
        sausageAlanMoscow.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 59, 38));
        sausageAlanMoscow.setExpirationDate(LocalDateTime.of(2022, 8, 7, 16, 51, 38));
        sausageAlanMoscow.setPrice(442.57);
        sausageAlanMoscow.setDiscount(0.0);

        products = new ArrayList<>(15);
        products.add(beerStellaArtois);
        products.add(beerHoegaardenBlanche);
        products.add(finlandiaCranberry);
        products.add(wineFianno);
        products.add(winePuebloViejo);
        products.add(cognacRemyMartin);
        products.add(tunaSteak);
        products.add(seabass);
        products.add(salmonSteak);
        products.add(plotva);
        products.add(sudak);
        products.add(porkNeck);
        products.add(porkMinceFresh);
        products.add(beefEntrecote);
        products.add(sausageAlanMoscow);
    }

    private void generateClientsListWithProductsList() {
        generateClientsList();
        generateProductsList();
        clients.get(0).getProducts().add(products.get(4));
        clients.get(0).getProducts().add(products.get(6));
        clients.get(0).getProducts().add(products.get(12));
        clients.get(1).getProducts().add(products.get(5));
        clients.get(1).getProducts().add(products.get(8));
        clients.get(1).getProducts().add(products.get(7));
        clients.get(2).getProducts().add(products.get(2));
        clients.get(2).getProducts().add(products.get(0));
        clients.get(2).getProducts().add(products.get(0));
        clients.get(2).getProducts().add(products.get(14));
        clientsWithProducts = new ArrayList<>(3);
        clientsWithProducts.add(clients.get(0));
        clientsWithProducts.add(clients.get(1));
        clientsWithProducts.add(clients.get(2));
    }
}
