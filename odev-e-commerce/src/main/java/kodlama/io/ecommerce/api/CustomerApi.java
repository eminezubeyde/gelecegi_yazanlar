package kodlama.io.ecommerce.api;

import kodlama.io.ecommerce.business.CreateOrder;
import kodlama.io.ecommerce.business.CustomerService;
import kodlama.io.ecommerce.business.concretes.ProductNotFoundException;
import kodlama.io.ecommerce.business.dto.CustomerDTO;
import kodlama.io.ecommerce.business.dto.requests.CreateCustomerRequest;
import kodlama.io.ecommerce.business.dto.responses.InformationOrderDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "customer")
@RequiredArgsConstructor
public class CustomerApi {

    private final CustomerService customerService;

    // create - delete - update
    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest){
        return customerService.create(createCustomerRequest);
    }

    // müşterinin sepetine ürün eklemek.

    @PutMapping("/basket")  // customer/basket
    public void addCustomerBasketForProduct(@RequestParam("customerId") Long customerId,@RequestParam("productId") int productId){
        customerService.addCustomerBasketForProduct(customerId,productId);
    }


    @PutMapping("basket/approve")
    public InformationOrderDetails approve(@RequestParam("customerId") Long customerId, @RequestBody CreateOrder createOrder) throws ProductNotFoundException {
        return customerService.approveBasket(customerId,createOrder);
    }







}
