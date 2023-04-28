package kodlama.io.ecommerce.business.concretes;

import jakarta.transaction.Transactional;
import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.business.dto.requests.UpdateProductRequest;
import kodlama.io.ecommerce.business.dto.requests.create.CreateProductRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateProductResponse;
import kodlama.io.ecommerce.business.dto.responses.get.ProductDTO;
import kodlama.io.ecommerce.business.mapping.abstracts.CategoryConverter;
import kodlama.io.ecommerce.business.mapping.abstracts.ProductConverter;
import kodlama.io.ecommerce.entities.Product;
import kodlama.io.ecommerce.entities.enums.Status;
import kodlama.io.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private final ProductRepository repository;
    private final ProductConverter productConverter;
    private final CategoryConverter categoryConverter;


    @Override
    public CreateProductResponse add(CreateProductRequest createProductRequest) {
        Product product = productConverter.createProductRequestToProduct(createProductRequest);
        repository.save(product);
        CreateProductResponse response = productConverter.productToCreateProductResponse(product);
        return response;

    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);

    }

    @Override
    @Transactional
    public Product update(UpdateProductRequest updateProductRequest, int productId) throws ProductNotFoundException {
        Optional<Product> product = repository.findById(productId);
        if(product.isEmpty()){
            throw new ProductNotFoundException();
        }
        product.get().setName(updateProductRequest.getName());
        product.get().setQuantity(updateProductRequest.getQuantity());
        product.get().setUnitPrice(updateProductRequest.getUnitPrice());
        product.get().setDescription(updateProductRequest.getDescription());
        product.get().setStatus(updateProductRequest.getStatus());
        return product.get();
    }




    @Override
    public List<ProductDTO> getAll() {

        return repository.findAll().stream()
                .filter(product -> product.getStatus().equals(Status.AVAILABLE))
                .map(productConverter::productToGetProductResponse).toList();

    }

    @Override
    public ProductDTO getById(int id) {
        Product product = repository.getById(id);
        if (product == null) {
            return null;
        }
        return productConverter.productToGetProductResponse(product);
    }

    @Override
    public Optional<Product> findById(int id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void reduceStock(int productId) throws ProductNotFoundException {
        Optional<Product> product = repository.findById(productId);
        if(product.isEmpty()){
            throw new ProductNotFoundException();
        }
        int quantity=product.get().getQuantity();
        product.get().setQuantity(--quantity);

    }


    private void checkIfDescriptionLengthValid(Product product) {
        if (product.getDescription().length() < 10 || product.getDescription().length() > 50)
            throw new IllegalArgumentException("Description length must be between 10 and 50 characters");
    }

    private void validateProduct(Product product) {

        checkIfDescriptionLengthValid(product);
    }

}
