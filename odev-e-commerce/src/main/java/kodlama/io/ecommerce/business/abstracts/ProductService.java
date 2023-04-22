package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.business.concretes.ProductNotFoundException;
import kodlama.io.ecommerce.business.dto.requests.UpdateProductRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateProductResponse;
import kodlama.io.ecommerce.business.dto.requests.create.CreateProductRequest;
import kodlama.io.ecommerce.business.dto.responses.get.ProductDTO;
import kodlama.io.ecommerce.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    CreateProductResponse add(CreateProductRequest createProductRequest);

    void delete(int id);

    Product update(UpdateProductRequest request, int id) throws ProductNotFoundException;

    List<ProductDTO> getAll();

    ProductDTO getById(int id);

    Optional<Product> findById(int id);


    void reduceStock(int productId) throws ProductNotFoundException;

}
