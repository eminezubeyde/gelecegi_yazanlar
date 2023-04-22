package kodlama.io.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Customer {


    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses=new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orders=new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Basket basket;


    public void addOrder(Order order){
        orders.add(order);
    }



}
