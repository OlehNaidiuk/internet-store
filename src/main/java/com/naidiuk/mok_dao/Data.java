package com.naidiuk.mok_dao;

import com.naidiuk.entity.Client;
import com.naidiuk.entity.Product;
import com.naidiuk.entity.ProductType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Data implements DataService {
    @Override
    public List<Client> getClients() {
        Client volodya = new Client();
        volodya.setId(new Random().nextInt(1_000_000));
        volodya.setName("Vladimir");
        volodya.setSurname("Degtyaryov");
        volodya.setAge(31);
        volodya.setDateOfBirth(LocalDate.of(1990, 6, 4));
        volodya.setCardNumber("9916 6898 4945 5470");
        volodya.setCardBalance(1983.39);
        volodya.setProducts(new ArrayList<>());

        Client stas = new Client();
        stas.setId(new Random().nextInt(1_000_000));
        stas.setName("Stas");
        stas.setSurname("Gurskiy");
        stas.setAge(32);
        stas.setDateOfBirth(LocalDate.of(1990, 2, 6));
        stas.setCardNumber("1472 3757 2227 4782");
        stas.setCardBalance(2707.58);
        stas.setProducts(new ArrayList<>());

        Client oleh = new Client();
        oleh.setId(new Random().nextInt(1_000_000));
        oleh.setName("Oleh");
        oleh.setSurname("Naidiuk");
        oleh.setAge(31);
        oleh.setDateOfBirth(LocalDate.of(1990, 5, 31));
        oleh.setCardNumber("7892 8993 8572 8538");
        oleh.setCardBalance(601.84);
        oleh.setProducts(new ArrayList<>());

        List<Client> clients = new ArrayList<>();
        clients.add(volodya);
        clients.add(stas);
        clients.add(oleh);

        return clients;
    }

    @Override
    public List<Product> getProducts() {
        Product beerStellaArtois = new Product();
        beerStellaArtois.setId(new Random().nextInt(1_000_000));
        beerStellaArtois.setName("Stella Artois");
        beerStellaArtois.setProductType(ProductType.ALCOHOL);
        beerStellaArtois.setDateAndTimeOfManufacture(LocalDateTime.of(2022, 2, 7, 17, 59, 38));
        beerStellaArtois.setExpirationDate(LocalDateTime.of(2022, 8, 7, 17, 59, 38));
        beerStellaArtois.setPrice(28.60);
        beerStellaArtois.setDiscount(0.0);

        Product beerHoegaardenBlanche = new Product();
        beerHoegaardenBlanche.setId(new Random().nextInt(1_000_000));
        beerHoegaardenBlanche.setName("Hoegaarden Blanche");
        beerHoegaardenBlanche.setProductType(ProductType.ALCOHOL);
        beerHoegaardenBlanche.setDateAndTimeOfManufacture(LocalDateTime.of(2022, 2, 7, 17, 59, 38));
        beerHoegaardenBlanche.setExpirationDate(LocalDateTime.of(2022, 8, 7, 17, 59, 38));
        beerHoegaardenBlanche.setPrice(56.90);
        beerHoegaardenBlanche.setDiscount(0.0);

        Product finlandiaCranberry = new Product();
        finlandiaCranberry.setId(new Random().nextInt(1_000_000));
        finlandiaCranberry.setName("Finlandia Cranberry");
        finlandiaCranberry.setProductType(ProductType.ALCOHOL);
        finlandiaCranberry.setDateAndTimeOfManufacture(LocalDateTime.of(2022, 2, 7, 17, 59, 38));
        finlandiaCranberry.setExpirationDate(LocalDateTime.of(2027, 2, 7, 17, 59, 38));
        finlandiaCranberry.setPrice(218.90);
        finlandiaCranberry.setDiscount(0.0);

        Product wineFianno = new Product();
        wineFianno.setId(new Random().nextInt(1_000_000));
        wineFianno.setName("Fianno Di Avellino");
        wineFianno.setProductType(ProductType.ALCOHOL);
        wineFianno.setDateAndTimeOfManufacture(LocalDateTime.of(2022, 2, 7, 17, 59, 38));
        wineFianno.setExpirationDate(LocalDateTime.of(2025, 2, 7, 17, 59, 38));
        wineFianno.setPrice(349.90);
        wineFianno.setDiscount(0.0);

        Product winePuebloViejo = new Product();
        winePuebloViejo.setId(new Random().nextInt(1_000_000));
        winePuebloViejo.setName("Pueblo Viejo Reserva");
        winePuebloViejo.setProductType(ProductType.ALCOHOL);
        winePuebloViejo.setDateAndTimeOfManufacture(LocalDateTime.of(2022, 2, 7, 17, 59, 38));
        winePuebloViejo.setExpirationDate(LocalDateTime.of(2025, 2, 7, 17, 59, 38));
        winePuebloViejo.setPrice(249.90);
        winePuebloViejo.setDiscount(0.0);

        Product cognacRemyMartin = new Product();
        cognacRemyMartin.setId(new Random().nextInt(1_000_000));
        cognacRemyMartin.setName("Remy Martin");
        cognacRemyMartin.setProductType(ProductType.ALCOHOL);
        cognacRemyMartin.setDateAndTimeOfManufacture(LocalDateTime.of(2022, 2, 7, 17, 59, 38));
        cognacRemyMartin.setExpirationDate(LocalDateTime.of(2099, 1, 1, 0, 0, 0));
        cognacRemyMartin.setPrice(249.99);
        cognacRemyMartin.setDiscount(0.0);

        Product tunaSteak = new Product();
        tunaSteak.setId(new Random().nextInt(1_000_000));
        tunaSteak.setName("Tuna Steak");
        tunaSteak.setProductType(ProductType.FISH);
        tunaSteak.setDateAndTimeOfManufacture(LocalDateTime.of(2022, 2, 7, 17, 59, 38));
        tunaSteak.setExpirationDate(LocalDateTime.of(2022, 8, 7, 17, 59, 38));
        tunaSteak.setPrice(979.90);
        tunaSteak.setDiscount(0.0);

        Product seabass = new Product();
        seabass.setId(new Random().nextInt(1_000_000));
        seabass.setName("Seabass");
        seabass.setProductType(ProductType.FISH);
        seabass.setDateAndTimeOfManufacture(LocalDateTime.of(2022, 2, 7, 17, 59, 38));
        seabass.setExpirationDate(LocalDateTime.of(2022, 2, 17, 17, 59, 38));
        seabass.setPrice(229.90);
        seabass.setDiscount(0.0);

        Product salmonSteak = new Product();
        salmonSteak.setId(new Random().nextInt(1_000_000));
        salmonSteak.setName("Salmon Steak");
        salmonSteak.setProductType(ProductType.MEAT);
        salmonSteak.setDateAndTimeOfManufacture(LocalDateTime.of(2022, 2, 7, 17, 59, 38));
        salmonSteak.setExpirationDate(LocalDateTime.of(2022, 2, 17, 17, 59, 38));
        salmonSteak.setPrice(539.90);
        salmonSteak.setDiscount(0.0);

        Product plotva = new Product();
        plotva.setId(new Random().nextInt(1_000_000));
        plotva.setName("Plotva");
        plotva.setProductType(ProductType.FISH);
        plotva.setDateAndTimeOfManufacture(LocalDateTime.of(2022, 2, 7, 17, 59, 38));
        plotva.setExpirationDate(LocalDateTime.of(2022, 8, 7, 17, 59, 38));
        plotva.setPrice(249.99);
        plotva.setDiscount(0.0);

        Product sudak = new Product();
        sudak.setId(new Random().nextInt(1_000_000));
        sudak.setName("Sudak");
        sudak.setProductType(ProductType.FISH);
        sudak.setDateAndTimeOfManufacture(LocalDateTime.of(2022, 2, 7, 17, 59, 38));
        sudak.setExpirationDate(LocalDateTime.of(2022, 8, 7, 17, 59, 38));
        sudak.setPrice(240.78);
        sudak.setDiscount(0.0);

        Product porkNeck = new Product();
        porkNeck.setId(new Random().nextInt(1_000_000));
        porkNeck.setName("Osheek");
        porkNeck.setProductType(ProductType.MEAT);
        porkNeck.setDateAndTimeOfManufacture(LocalDateTime.of(2022, 2, 7, 17, 59, 38));
        porkNeck.setExpirationDate(LocalDateTime.of(2022, 2, 14, 17, 59, 38));
        porkNeck.setPrice(148.99);
        porkNeck.setDiscount(0.0);

        Product porkMinceFresh = new Product();
        porkMinceFresh.setId(new Random().nextInt(1_000_000));
        porkMinceFresh.setName("Pork Mince Fresh");
        porkMinceFresh.setProductType(ProductType.MEAT);
        porkMinceFresh.setDateAndTimeOfManufacture(LocalDateTime.of(2022, 2, 7, 17, 59, 38));
        porkMinceFresh.setExpirationDate(LocalDateTime.of(2022, 2, 14, 17, 59, 38));
        porkMinceFresh.setPrice(114.90);
        porkMinceFresh.setDiscount(0.0);

        Product beefEntrecote = new Product();
        beefEntrecote.setId(new Random().nextInt(1_000_000));
        beefEntrecote.setName("Beef Entrecote");
        beefEntrecote.setProductType(ProductType.MEAT);
        beefEntrecote.setDateAndTimeOfManufacture(LocalDateTime.of(2022, 2, 7, 17, 59, 38));
        beefEntrecote.setExpirationDate(LocalDateTime.of(2022, 2, 14, 17, 59, 38));
        beefEntrecote.setPrice(1499.00);
        beefEntrecote.setDiscount(0.0);

        Product sausageAlanMoscow = new Product();
        sausageAlanMoscow.setId(new Random().nextInt(1_000_000));
        sausageAlanMoscow.setName("Alan Moscow");
        sausageAlanMoscow.setProductType(ProductType.MEAT);
        sausageAlanMoscow.setDateAndTimeOfManufacture(LocalDateTime.of(2022, 2, 7, 17, 59, 38));
        sausageAlanMoscow.setExpirationDate(LocalDateTime.of(2022, 8, 7, 17, 59, 38));
        sausageAlanMoscow.setPrice(442.57);
        sausageAlanMoscow.setDiscount(0.0);

        List<Product> products = new ArrayList<>(15);
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

        return products;
    }

    @Override
    public List<Client> getClientsWithTheirProducts() {
//        List<Client> clients = getClients();
//        List<Product> products = getProducts();
//        for (Client client : clients) {
//            client.getProducts().add()
//        }
        return new ArrayList<>();
    }
}
