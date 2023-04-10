package org.example;

public class CustomerManager {
    private CheckService checkService;

    public CustomerManager(CheckService checkService) {
        this.checkService = checkService;
    }

    public void add(Customer customer) {
        if (checkService.check(customer)) {
            System.out.println("eklendi");
        }else{
            System.out.println("kullanıcı eklenmedi");
        }
    }
}
