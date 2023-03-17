package org.example;

import org.example.business.concretes.CustomerManager;
import org.example.business.concretes.SpecialOfferManager;
import org.example.data.entity.Customer;
import org.example.data.entity.Game;
import org.example.data.entity.SpecialOffer;
import org.example.data.repo.CustomerRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Verification verification = new Verification();
        SpecialOffer specialOffer1 = new SpecialOffer(1, "Bahar İndirimleri", 25);

        SpecialOfferManager specialOfferManager = new SpecialOfferManager();
        specialOfferManager.add(specialOffer1);

        List<Game> games = new ArrayList<>();//sistemdeki oyunlar
        Game game1 = new Game(1, "Minecraft", 200.0, specialOffer1);
        Game game2 = new Game(2, "WoW", 500.0, null);
        games.add(game1);
        games.add(game2);
        CustomerManager customerManager = new CustomerManager(verification);
        Customer customer1 = new Customer(1, "ozcan@gmail.com", "123456", "11111111111", "Özcan", "Elmacı",
                new Date(1999, 1, 1), new ArrayList<>());

        customerManager.add(customer1);

        Customer customer2 = new Customer(2, "samet@gmail.com", "123456", "22222222222", "Samet", "Yüksel",
                new Date(1999, 2, 2), new ArrayList<>());

        customerManager.add(customer2);

        Customer customer3 =  new Customer(4, "zubeyde@gmail.com", "123456", "55555555555", "Zübeyde", "Yalçın",
                new Date(1999, 4, 4), new ArrayList<>());//nationalityId repoda bulunan customerdan farklı

        customerManager.add(customer3);

        customerManager.buyGame(customer1, game1);
        customerManager.buyGame(customer1, game2);

        customerManager.update(customer2);
        customerManager.delete(customer2);

        specialOfferManager.update(specialOffer1);
        specialOfferManager.delete(specialOffer1);

        System.out.println(customer1);


    }
}