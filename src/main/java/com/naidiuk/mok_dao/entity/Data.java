package com.naidiuk.mok_dao.entity;

import com.naidiuk.entity.Client;
import com.naidiuk.entity.Product;
import com.naidiuk.entity.ProductType;
import com.naidiuk.mok_dao.service.DataService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Data implements DataService {
    private List<Client> clients;
    private List<Client> clientsWithProducts;
    private List<Product> products;

    @Override
    public List<Client> getClients() {
        generateClientsList();
        return clients;
    }

    @Override
    public List<Product> getProducts() {
        generateProductsList();
        return products;
    }

    @Override
    public List<Client> getClientsWithTheirProducts() {
        generateClientsListWithProductsList();
        return clientsWithProducts;
    }

    private void generateClientsList() {
        Client volodya = new Client();
        volodya.setId(1);
        volodya.setName("Vladimir");
        volodya.setSurname("Degtyaryov");
        volodya.setAge(31);
        volodya.setDateOfBirth(LocalDate.of(1990, 6, 4));
        volodya.setCardNumber("9916 6898 4945 5470");
        volodya.setCardBalance(1983.39);
        volodya.setProducts(new ArrayList<>());

        Client stas = new Client();
        stas.setId(2);
        stas.setName("Stas");
        stas.setSurname("Gurskiy");
        stas.setAge(32);
        stas.setDateOfBirth(LocalDate.of(1990, 2, 6));
        stas.setCardNumber("1472 3757 2227 4782");
        stas.setCardBalance(2707.58);
        stas.setProducts(new ArrayList<>());

        Client oleh = new Client();
        oleh.setId(3);
        oleh.setName("Oleh");
        oleh.setSurname("Naidiuk");
        oleh.setAge(31);
        oleh.setDateOfBirth(LocalDate.of(1990, 5, 31));
        oleh.setCardNumber("7892 8993 8572 8538");
        oleh.setCardBalance(601.84);
        oleh.setProducts(new ArrayList<>());

        clients = new ArrayList<>(3);
        clients.add(volodya);
        clients.add(stas);
        clients.add(oleh);
    }

    private void generateProductsList() {
        Product beerStellaArtois = new Product();
        beerStellaArtois.setId(1);
        beerStellaArtois.setName("Stella Artois");
        beerStellaArtois.setProductType(ProductType.ALCOHOL);
        beerStellaArtois.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 45, 38));
        beerStellaArtois.setExpirationDate(LocalDateTime.of(2022, 8, 7, 17, 59, 38));
        beerStellaArtois.setPrice(28.60);
        beerStellaArtois.setDiscount(0.0);

        Product beerHoegaardenBlanche = new Product();
        beerHoegaardenBlanche.setId(2);
        beerHoegaardenBlanche.setName("Hoegaarden Blanche");
        beerHoegaardenBlanche.setProductType(ProductType.ALCOHOL);
        beerHoegaardenBlanche.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 46, 38));
        beerHoegaardenBlanche.setExpirationDate(LocalDateTime.of(2022, 8, 7, 17, 59, 38));
        beerHoegaardenBlanche.setPrice(56.90);
        beerHoegaardenBlanche.setDiscount(0.0);

        Product finlandiaCranberry = new Product();
        finlandiaCranberry.setId(3);
        finlandiaCranberry.setName("Finlandia Cranberry");
        finlandiaCranberry.setProductType(ProductType.ALCOHOL);
        finlandiaCranberry.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 47, 38));
        finlandiaCranberry.setExpirationDate(LocalDateTime.of(2027, 2, 7, 17, 59, 38));
        finlandiaCranberry.setPrice(218.90);
        finlandiaCranberry.setDiscount(0.0);

        Product wineFianno = new Product();
        wineFianno.setId(4);
        wineFianno.setName("Fianno Di Avellino");
        wineFianno.setProductType(ProductType.ALCOHOL);
        wineFianno.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 48, 38));
        wineFianno.setExpirationDate(LocalDateTime.of(2025, 2, 7, 17, 59, 38));
        wineFianno.setPrice(349.90);
        wineFianno.setDiscount(0.0);

        Product winePuebloViejo = new Product();
        winePuebloViejo.setId(5);
        winePuebloViejo.setName("Pueblo Viejo Reserva");
        winePuebloViejo.setProductType(ProductType.ALCOHOL);
        winePuebloViejo.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 49, 38));
        winePuebloViejo.setExpirationDate(LocalDateTime.of(2025, 2, 7, 17, 59, 38));
        winePuebloViejo.setPrice(249.90);
        winePuebloViejo.setDiscount(0.0);

        Product cognacRemyMartin = new Product();
        cognacRemyMartin.setId(6);
        cognacRemyMartin.setName("Remy Martin");
        cognacRemyMartin.setProductType(ProductType.ALCOHOL);
        cognacRemyMartin.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 50, 38));
        cognacRemyMartin.setExpirationDate(LocalDateTime.of(2099, 1, 1, 0, 0, 0));
        cognacRemyMartin.setPrice(249.99);
        cognacRemyMartin.setDiscount(0.0);

        Product tunaSteak = new Product();
        tunaSteak.setId(7);
        tunaSteak.setName("Tuna Steak");
        tunaSteak.setProductType(ProductType.FISH);
        tunaSteak.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 51, 38));
        tunaSteak.setExpirationDate(LocalDateTime.of(2022, 8, 7, 17, 59, 38));
        tunaSteak.setPrice(979.90);
        tunaSteak.setDiscount(0.0);

        Product seabass = new Product();
        seabass.setId(8);
        seabass.setName("Seabass");
        seabass.setProductType(ProductType.FISH);
        seabass.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 52, 38));
        seabass.setExpirationDate(LocalDateTime.of(2022, 2, 17, 17, 59, 38));
        seabass.setPrice(229.90);
        seabass.setDiscount(0.0);

        Product salmonSteak = new Product();
        salmonSteak.setId(9);
        salmonSteak.setName("Salmon Steak");
        salmonSteak.setProductType(ProductType.MEAT);
        salmonSteak.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 53, 38));
        salmonSteak.setExpirationDate(LocalDateTime.of(2022, 2, 17, 17, 59, 38));
        salmonSteak.setPrice(539.90);
        salmonSteak.setDiscount(0.0);

        Product plotva = new Product();
        plotva.setId(10);
        plotva.setName("Plotva");
        plotva.setProductType(ProductType.FISH);
        plotva.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 54, 38));
        plotva.setExpirationDate(LocalDateTime.of(2022, 8, 7, 17, 59, 38));
        plotva.setPrice(249.99);
        plotva.setDiscount(0.0);

        Product sudak = new Product();
        sudak.setId(11);
        sudak.setName("Sudak");
        sudak.setProductType(ProductType.FISH);
        sudak.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 55, 38));
        sudak.setExpirationDate(LocalDateTime.of(2022, 8, 7, 17, 59, 38));
        sudak.setPrice(240.78);
        sudak.setDiscount(0.0);

        Product porkNeck = new Product();
        porkNeck.setId(12);
        porkNeck.setName("Osheek");
        porkNeck.setProductType(ProductType.MEAT);
        porkNeck.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 56, 38));
        porkNeck.setExpirationDate(LocalDateTime.of(2022, 2, 14, 17, 59, 38));
        porkNeck.setPrice(148.99);
        porkNeck.setDiscount(0.0);

        Product porkMinceFresh = new Product();
        porkMinceFresh.setId(13);
        porkMinceFresh.setName("Pork Mince Fresh");
        porkMinceFresh.setProductType(ProductType.MEAT);
        porkMinceFresh.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 57, 38));
        porkMinceFresh.setExpirationDate(LocalDateTime.of(2022, 2, 14, 17, 59, 38));
        porkMinceFresh.setPrice(114.90);
        porkMinceFresh.setDiscount(0.0);

        Product beefEntrecote = new Product();
        beefEntrecote.setId(14);
        beefEntrecote.setName("Beef Entrecote");
        beefEntrecote.setProductType(ProductType.MEAT);
        beefEntrecote.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 58, 38));
        beefEntrecote.setExpirationDate(LocalDateTime.of(2022, 2, 14, 17, 59, 38));
        beefEntrecote.setPrice(1499.00);
        beefEntrecote.setDiscount(0.0);

        Product sausageAlanMoscow = new Product();
        sausageAlanMoscow.setId(15);
        sausageAlanMoscow.setName("Alan Moscow");
        sausageAlanMoscow.setProductType(ProductType.MEAT);
        sausageAlanMoscow.setManufacturedDate(LocalDateTime.of(2022, 2, 7, 17, 59, 38));
        sausageAlanMoscow.setExpirationDate(LocalDateTime.of(2022, 8, 7, 17, 59, 38));
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
        clientsWithProducts = new ArrayList<>(3);
        for (Client client : clients) {
            for (int j = 0; j < new Random().nextInt(7); j++) {
                Product product = products.get(new Random().nextInt(15));
                client.addProduct(product);
            }
            clientsWithProducts.add(client);
        }
    }
}
