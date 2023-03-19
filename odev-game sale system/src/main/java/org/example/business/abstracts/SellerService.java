package org.example.business.abstracts;

import org.example.data.entity.Seller;

public interface SellerService {

    void add(Seller seller);
    void update(Seller seller);
    void delete(Seller seller);
}
