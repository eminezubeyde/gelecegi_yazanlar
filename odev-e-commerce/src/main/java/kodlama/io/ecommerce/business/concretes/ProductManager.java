package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.entities.Product;
import kodlama.io.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private final ProductRepository productRepository;


    @Override
    public Product add(Product product) {
        validateProduct(product);
        return productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);

    }

    @Override
    public Product update(Product product, int id) {
        validateProduct(product);
        product.setId(product.getId());
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(int id) {
        return productRepository.findById(id).orElseThrow();
    }

    private void checkIfUnitPriceValid(Product product) {
        if (product.getUnitPrice() <= 0)
            throw new IllegalArgumentException("price cannot be less than or equal to zero");

    }

    private void checkIfQuantityValid(Product product) {
        if (product.getQuantity() < 0) throw new IllegalArgumentException("Quantity cannot be less than zero");
    }

    private void checkIfDescriptionLengthValid(Product product) {
        if (product.getDescription().length() < 10 || product.getDescription().length() > 50)
            throw new IllegalArgumentException("Description length must be between 10 and 50 characters");
    }

    private void validateProduct(Product product) {
        checkIfUnitPriceValid(product);
        checkIfQuantityValid(product);
        checkIfDescriptionLengthValid(product);
    }

}
