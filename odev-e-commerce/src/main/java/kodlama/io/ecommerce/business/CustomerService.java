package kodlama.io.ecommerce.business;

import kodlama.io.ecommerce.business.concretes.ProductNotFoundException;
import kodlama.io.ecommerce.business.dto.requests.CreateCustomerRequest;
import kodlama.io.ecommerce.business.dto.responses.InformationOrderDetails;
import kodlama.io.ecommerce.business.dto.CustomerDTO;

public interface CustomerService {


    CustomerDTO create(CreateCustomerRequest createCustomerRequest);

    void addCustomerBasketForProduct(Long customerId, int productId);


    InformationOrderDetails approveBasket(Long customerId, CreateOrder createOrder) throws ProductNotFoundException;

}
