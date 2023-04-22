package kodlama.io.ecommerce.business;

import jakarta.transaction.Transactional;
import kodlama.io.ecommerce.business.concretes.ProductNotFoundException;
import kodlama.io.ecommerce.business.dto.requests.CreateCustomerRequest;
import kodlama.io.ecommerce.business.dto.responses.InformationOrderDetails;
import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.business.dto.CustomerDTO;
import kodlama.io.ecommerce.entities.*;
import kodlama.io.ecommerce.repository.CustomerRepository;
import kodlama.io.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerManager implements CustomerService {

    private final CustomerRepository customerRepository;

    private final ProductService productService;
    private final ProductRepository productRepository;

    private final CustomerConverter customerConverter;


    @Override
    public CustomerDTO create(CreateCustomerRequest createCustomerRequest) {
        Customer customer = new Customer();
        customer.setEmail(createCustomerRequest.getEmail());
        customer.setName(createCustomerRequest.getName());
        customer.setBasket(new Basket());
        customerRepository.save(customer);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setName(customer.getName());

        return customerDTO;
    }

    @Override
    @Transactional
    public void addCustomerBasketForProduct(Long customerId, int productId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            throw new RuntimeException("kullanıcı bulunamadı.");
        }
        Optional<Product> product = productService.findById(productId);
        if (product.isEmpty()) {
            throw new RuntimeException("Ürün  bulunamadı.");
        }
        customer.get().getBasket().addProduct(product.get());

    }

    @Override
    public InformationOrderDetails approveBasket(Long customerId, CreateOrder createOrder) throws ProductNotFoundException {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            throw new RuntimeException("kullanıcı bulunamadı.");
        }

        // odeme onaylama işi .

        Order order = new Order(); // kullanıcı sipariş oluşturdu.

        order.setProducts(customer.get().getBasket().getProducts());

        Invoice invoice = new Invoice();
        invoice.setInvoiceAddress(customerConverter.dtoToEntity(createOrder.getInvoiceAddress()));
        invoice.setOrderAddress(customerConverter.dtoToEntity(createOrder.getOrderAddress()));
        invoice.setCreatedDate(LocalDate.now());
        invoice.setTotalPrice(customer.get().getBasket().calculateTotalPrice());

        order.setInvoice(invoice);


        customer.get().addOrder(order);

        for (Product product : customer.get().getBasket().getProducts()) {
            productService.reduceStock(product.getId());
        }

        customer.get().getBasket().getProducts().clear();

        InformationOrderDetails informationOrderDetails=new InformationOrderDetails();
        informationOrderDetails.setOrderAddress(createOrder.getOrderAddress());
        informationOrderDetails.setInvoiceAddress(createOrder.getInvoiceAddress());
        informationOrderDetails.setTotalPrice(invoice.getTotalPrice());
        informationOrderDetails.setDate(LocalDateTime.now());
        return informationOrderDetails;
    }
}
