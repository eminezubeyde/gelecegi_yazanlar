package org.example;


public class Main {
    public static void main(String[] args) {
        Customer customer=new Customer("zübeyde","yalçın","1998","11111111111");
        CustomerManager customerManager=new CustomerManager(new EDevletServiceAdapter());
        customerManager.add(customer);
    }
}