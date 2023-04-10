package org.example;

public class EDevletServiceAdapter implements CheckService{
    @Override
    public boolean check(Customer customer) {
        EDevletService eDevletService=new EDevletService();
        return eDevletService.checkIfRealPerson(customer);
    }
}
