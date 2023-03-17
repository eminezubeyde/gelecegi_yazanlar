package org.example.business.concretes;

import org.example.business.abstracts.SellerService;
import org.example.data.entity.Seller;

public class SellerManager implements SellerService {
    @Override
    public void add(Seller seller) {
        System.out.println(seller.getCompanyName() + " sisteme eklendi.");
    }

    @Override
    public void update(Seller seller) {
        System.out.println(seller.getCompanyName() + " güncellendi.");
    }

    @Override
    public void delete(Seller seller) {
        System.out.println(seller.getCompanyName() + " sistemden silindi.");
    }

    //satış metodu eklenecek
}
