package org.example.data.repo;

import org.example.data.entity.Customer;
import org.example.data.entity.Game;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerRepo {

    List<Customer> customers = new ArrayList<>();

    public CustomerRepo() {
        Customer customer1 = new Customer(1, "ozcan@gmail.com", "123456", "11111111111", "Özcan", "Elmacı",
                new Date(1999, 1, 1), new ArrayList<Game>());

        Customer customer2 = new Customer(2, "samet@gmail.com", "123456", "22222222222", "Samet", "Yüksel",
                new Date(1999, 2, 2), new ArrayList<Game>());

        Customer customer3 = new Customer(3, "yasin@gmail.com", "123456", "333333333333", "Yasin", "Ünsal",
                new Date(1999, 3, 3), new ArrayList<Game>());

        Customer customer4 = new Customer(4, "zubeyde@gmail.com", "123456", "44444444444", "Zübeyde", "Yalçın",
                new Date(1999, 4, 4), new ArrayList<Game>());

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);

    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
