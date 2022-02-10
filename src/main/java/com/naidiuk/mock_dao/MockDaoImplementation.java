package com.naidiuk.mock_dao;

import com.naidiuk.entity.Client;
import com.naidiuk.entity.Product;
import com.naidiuk.entity.ProductType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MockDaoImplementation implements MockDaoService {
    private final List<Client> clientsList;
    private final List<Product> productsList;

    public MockDaoImplementation() {
        clientsList = generateClientsList();
        productsList = generateProductsList();
    }

    @Override
    public List<Client> getClientsList() {
        return clientsList;
    }

    @Override
    public List<Product> getProductsList() {
        return productsList;
    }

    private List<Client> generateClientsList() {
        Client neo = new Client();
        neo.setId(1);
        neo.setName("Thomas");
        neo.setSurname("Anderson");
        neo.setAge(27);
        neo.setDateOfBirth(LocalDate.of(1990, 6, 4));
        neo.setCardNumber("9916 6898 4945 5470");
        neo.setCardBalance(2983.39);

        Client keanu = new Client();
        keanu.setId(2);
        keanu.setName("Keanu");
        keanu.setSurname("Reeves");
        keanu.setAge(17);
        keanu.setDateOfBirth(LocalDate.of(1990, 2, 6));
        keanu.setCardNumber("1472 3757 2227 4782");
        keanu.setCardBalance(217.58);

        Client agentSmith = new Client();
        agentSmith.setId(3);
        agentSmith.setName("Agent");
        agentSmith.setSurname("Smith");
        agentSmith.setAge(31);
        agentSmith.setDateOfBirth(LocalDate.of(1990, 5, 31));
        agentSmith.setCardNumber("7892 8993 8572 8538");
        agentSmith.setCardBalance(601.84);

        List<Client> clientsList = new ArrayList<>(3);
        clientsList.add(neo);
        clientsList.add(keanu);
        clientsList.add(agentSmith);
        return clientsList;
    }

    private List<Product> generateProductsList() {
        Product beerStellaArtois = new Product();
        beerStellaArtois.setId(1);
        beerStellaArtois.setName("Stella Artois");
        beerStellaArtois.setProductType(ProductType.ALCOHOL);
        beerStellaArtois.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 2,2,2));
        beerStellaArtois.setExpirationDate(LocalDateTime.of(2022, 8, 7, 2,2,2));
        beerStellaArtois.setPrice(28.60);
        beerStellaArtois.setDiscount(0.0);

        Product beerHoegaardenBlanche = new Product();
        beerHoegaardenBlanche.setId(2);
        beerHoegaardenBlanche.setName("Hoegaarden Blanche");
        beerHoegaardenBlanche.setProductType(ProductType.ALCOHOL);
        beerHoegaardenBlanche.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 1,1,1));
        beerHoegaardenBlanche.setExpirationDate(LocalDateTime.of(2022, 8, 7, 1,1,1));
        beerHoegaardenBlanche.setPrice(56.90);
        beerHoegaardenBlanche.setDiscount(0.0);

        Product finlandiaCranberry = new Product();
        finlandiaCranberry.setId(3);
        finlandiaCranberry.setName("Finlandia Cranberry");
        finlandiaCranberry.setProductType(ProductType.ALCOHOL);
        finlandiaCranberry.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 0,0,0));
        finlandiaCranberry.setExpirationDate(LocalDateTime.of(2027, 2, 7, 0,0,0));
        finlandiaCranberry.setPrice(218.90);
        finlandiaCranberry.setDiscount(0.0);

        Product wineFianno = new Product();
        wineFianno.setId(4);
        wineFianno.setName("Fianno Di Avellino");
        wineFianno.setProductType(ProductType.ALCOHOL);
        wineFianno.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 6,6,6));
        wineFianno.setExpirationDate(LocalDateTime.of(2025, 2, 7, 6,6,6));
        wineFianno.setPrice(349.90);
        wineFianno.setDiscount(0.0);

        Product winePuebloViejo = new Product();
        winePuebloViejo.setId(5);
        winePuebloViejo.setName("Pueblo Viejo Reserva");
        winePuebloViejo.setProductType(ProductType.ALCOHOL);
        winePuebloViejo.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 4,4,4));
        winePuebloViejo.setExpirationDate(LocalDateTime.of(2025, 2, 7, 4,4,4));
        winePuebloViejo.setPrice(249.90);
        winePuebloViejo.setDiscount(0.0);

        Product cognacRemyMartin = new Product();
        cognacRemyMartin.setId(6);
        cognacRemyMartin.setName("Remy Martin");
        cognacRemyMartin.setProductType(ProductType.ALCOHOL);
        cognacRemyMartin.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 8,8,8));
        cognacRemyMartin.setExpirationDate(LocalDateTime.of(2099, 12, 31, 8,8,8));
        cognacRemyMartin.setPrice(2049.99);
        cognacRemyMartin.setDiscount(0.0);

        Product tunaSteak = new Product();
        tunaSteak.setId(7);
        tunaSteak.setName("Tuna Steak");
        tunaSteak.setProductType(ProductType.FISH);
        tunaSteak.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 3,3,3));
        tunaSteak.setExpirationDate(LocalDateTime.of(2022, 8, 7, 3,3,3));
        tunaSteak.setPrice(979.90);
        tunaSteak.setDiscount(0.0);

        Product seabass = new Product();
        seabass.setId(8);
        seabass.setName("Seabass");
        seabass.setProductType(ProductType.FISH);
        seabass.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 7,7,7));
        seabass.setExpirationDate(LocalDateTime.of(2022, 2, 17, 7,7,7));
        seabass.setPrice(229.90);
        seabass.setDiscount(0.0);

        Product salmonSteak = new Product();
        salmonSteak.setId(9);
        salmonSteak.setName("Salmon Steak");
        salmonSteak.setProductType(ProductType.FISH);
        salmonSteak.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 5,5,5));
        salmonSteak.setExpirationDate(LocalDateTime.of(2022, 2, 17, 5,5,5));
        salmonSteak.setPrice(539.90);
        salmonSteak.setDiscount(0.0);

        Product plotva = new Product();
        plotva.setId(10);
        plotva.setName("Plotva");
        plotva.setProductType(ProductType.FISH);
        plotva.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 11,11,11));
        plotva.setExpirationDate(LocalDateTime.of(2022, 8, 7, 11,11,11));
        plotva.setPrice(249.99);
        plotva.setDiscount(0.0);

        Product sudak = new Product();
        sudak.setId(11);
        sudak.setName("Sudak");
        sudak.setProductType(ProductType.FISH);
        sudak.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 10,10,10));
        sudak.setExpirationDate(LocalDateTime.of(2022, 8, 7, 10,10,10));
        sudak.setPrice(240.78);
        sudak.setDiscount(0.0);

        Product porkNeck = new Product();
        porkNeck.setId(12);
        porkNeck.setName("Osheek");
        porkNeck.setProductType(ProductType.MEAT);
        porkNeck.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 9,9,9));
        porkNeck.setExpirationDate(LocalDateTime.of(2022, 2, 14, 9,9,9));
        porkNeck.setPrice(148.99);
        porkNeck.setDiscount(0.0);

        Product porkMinceFresh = new Product();
        porkMinceFresh.setId(13);
        porkMinceFresh.setName("Pork Mince Fresh");
        porkMinceFresh.setProductType(ProductType.MEAT);
        porkMinceFresh.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 13,13,13));
        porkMinceFresh.setExpirationDate(LocalDateTime.of(2022, 2, 14, 13,13,13));
        porkMinceFresh.setPrice(114.90);
        porkMinceFresh.setDiscount(0.0);

        Product beefEntrecote = new Product();
        beefEntrecote.setId(14);
        beefEntrecote.setName("Beef Entrecote");
        beefEntrecote.setProductType(ProductType.MEAT);
        beefEntrecote.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 12, 12, 12));
        beefEntrecote.setExpirationDate(LocalDateTime.of(2022, 2, 14, 12, 12, 12));
        beefEntrecote.setPrice(1499.00);
        beefEntrecote.setDiscount(0.0);

        Product sausageAlanMoscow = new Product();
        sausageAlanMoscow.setId(15);
        sausageAlanMoscow.setName("Alan Moscow");
        sausageAlanMoscow.setProductType(ProductType.MEAT);
        sausageAlanMoscow.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 14,14,14));
        sausageAlanMoscow.setExpirationDate(LocalDateTime.of(2022, 8, 7, 14,14,14));
        sausageAlanMoscow.setPrice(442.57);
        sausageAlanMoscow.setDiscount(0.0);

        List<Product> productsList = new ArrayList<>(15);
        productsList.add(beerStellaArtois);
        productsList.add(beerHoegaardenBlanche);
        productsList.add(finlandiaCranberry);
        productsList.add(wineFianno);
        productsList.add(winePuebloViejo);
        productsList.add(cognacRemyMartin);
        productsList.add(tunaSteak);
        productsList.add(seabass);
        productsList.add(salmonSteak);
        productsList.add(plotva);
        productsList.add(sudak);
        productsList.add(porkNeck);
        productsList.add(porkMinceFresh);
        productsList.add(beefEntrecote);
        productsList.add(sausageAlanMoscow);
        return productsList;
    }
}
