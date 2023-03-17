package org.example.business.concretes;

import org.example.business.abstracts.SpecialOfferService;
import org.example.data.entity.SpecialOffer;

public class SpecialOfferManager implements SpecialOfferService {

    @Override
    public void add(SpecialOffer specialOffer) {
        System.out.println(specialOffer.getName() + " sisteme eklendi.");
    }

    @Override
    public void update(SpecialOffer specialOffer) {
        System.out.println(specialOffer.getName() + " güncellendi");
    }

    @Override
    public void delete(SpecialOffer specialOffer) {
        System.out.println(specialOffer.getName() + " sistemden silindi.");
    }
}
