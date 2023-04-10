package org.example;

import java.util.Objects;

public class Customer {
    private String name;
    private String lastName;
    private String birthYear;
    private String identityNumber;

    public Customer(String name, String lastName, String birthYear, String identityNumber) {
        this.name = name;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.identityNumber = identityNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }


    @Override
    public boolean equals(Object o) {

        Customer customer = (Customer) o;
        return name.equals(customer.name) && lastName.equals(customer.lastName) && birthYear.equals(customer.birthYear) && identityNumber.equals(customer.identityNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, birthYear, identityNumber);
    }
}


