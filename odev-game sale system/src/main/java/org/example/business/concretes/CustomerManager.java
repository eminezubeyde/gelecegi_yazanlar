package org.example.business.concretes;

import org.example.Verification;
import org.example.business.abstracts.CustomerService;
import org.example.data.entity.Customer;
import org.example.data.entity.Game;
import org.example.data.repo.CustomerRepo;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager implements CustomerService {

    private List<Customer> customers = new ArrayList<>();
    private Verification verification;

    public CustomerManager(Verification verification) {
        this.verification = verification;
    }

    @Override
    public void add(Customer customer) {
        if(verification.isValidCustomer(customer)){
            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " sisteme eklendi.");
            customers.add(customer);

        }
        else{
            System.out.println("Lütfen bilgilerinizi kontrol ediniz.");
        }
    }
    @Override
    public void update(Customer customer) {
        if(customers.contains(customer)){
            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " güncellendi.");
        }
        else{
            System.out.println("Sistemimizde böyle bir müşteri bulunmamaktadır.");
        }

    }

    @Override
    public void delete(Customer customer) {
        if(customers.contains(customer)){
            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " sistemden silindi. ");
            customers.remove(customer);
        }
        else{
            System.out.println("Sistemimizde böyle bir müşteri bulunmamaktadır.");
        }
    }
    @Override
    public void buyGame(Customer customer, Game game) {
        if(customers.contains(customer)){
            customer.getGames().add(game);
            if(game.getSpecialOffer() != null){
                double newPrice = game.getPrice() - (game.getPrice()*(game.getSpecialOffer().getDiscount()/100));
                System.out.println("Eski Fiyat: " + game.getPrice());
                System.out.println("Uygulanan Kampanya: " + game.getSpecialOffer().getName());
                System.out.println("İndirim Oranı: " + game.getSpecialOffer().getDiscount());
                System.out.println("İndirimli Fiyat: " + newPrice);
            }
            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " + game.getName() + " isimli oyunu satın aldı.");
        }
    }
    public List<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
