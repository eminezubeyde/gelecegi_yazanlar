package org.example;

import java.util.Set;

public class EDevletService {
    Customer person1 = new Customer("zübeyde", "yalçın", "1998", "11111111111");
    Customer person2 = new Customer("berfin", "açıkgöz", "2000", "22222222222");
    Customer person3 = new Customer("nilay", "aydemir", "1999", "3333333333");
    Set<Customer> eDevletKisiListesi = Set.of(person1, person2, person3);
    public boolean checkIfRealPerson(Customer customer){

        if(eDevletKisiListesi.contains(customer)){
            System.out.println("kişi gerçektir");
            return true;
        } else{
            System.out.println("gerçek kişi değildir");
            return false;
        }
    }
}
