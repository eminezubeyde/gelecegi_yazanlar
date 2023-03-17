package org.example.business.abstracts;

import org.example.data.entity.Customer;
import org.example.data.entity.Game;

public interface CustomerService {
    void add(Customer customer);
    void update(Customer customer);
    void delete(Customer customer);

    void buyGame(Customer customer, Game game);
}
