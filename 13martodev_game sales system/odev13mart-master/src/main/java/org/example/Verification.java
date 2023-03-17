package org.example;

import org.example.data.entity.Customer;
import org.example.data.repo.CustomerRepo;

import java.util.ArrayList;
import java.util.List;

public class Verification {

    public List<Customer> customers = new ArrayList<>(); // registered Customers

    public Verification() {
        CustomerRepo customerRepo = new CustomerRepo();
        this.customers = customerRepo.getCustomers();
    }

    public Verification(List<Customer> customers) {
        this.customers = customers;
    }

    public boolean isValidCustomer(Customer newCustomer){
        /**
         * Checks if @Customer is a valid Customer.
         *
        return this.Customers.contains(Customer);*/


        boolean isValid = false;
        for (Customer customer : customers) {
            if(customer.getFirstName().equals(newCustomer.getFirstName()) && customer.getLastName().equals(newCustomer.getLastName()) &&
                customer.getBirthDate().equals(newCustomer.getBirthDate()) && customer.getNationalityId().equals(newCustomer.getNationalityId())){
                isValid = true;
                break;
            }
            else{
                isValid = false;
            }

        }
        return isValid;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    //isvalidSeller, isValidUser,
}
