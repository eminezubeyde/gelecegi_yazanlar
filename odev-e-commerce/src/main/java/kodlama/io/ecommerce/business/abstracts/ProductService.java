package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.business.dto.responses.create.CreateProductResponse;
import kodlama.io.ecommerce.business.dto.requests.create.CreateProductRequest;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllProductResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetProductResponse;
import kodlama.io.ecommerce.entities.Product;

import java.util.List;

public interface ProductService {
    CreateProductResponse add(CreateProductRequest createProductRequest);

    void delete(int id);

    Product update(Product product, int id);

    List<GetProductResponse> getAll();

    GetProductResponse getById(int id);
}
