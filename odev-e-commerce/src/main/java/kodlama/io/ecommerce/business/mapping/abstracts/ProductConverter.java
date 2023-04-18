package kodlama.io.ecommerce.business.mapping.abstracts;

import kodlama.io.ecommerce.business.dto.requests.create.CreateProductRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateProductResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetProductResponse;
import kodlama.io.ecommerce.entities.Product;

public interface ProductConverter {
    Product createProductRequestToProduct(CreateProductRequest createProductRequest);

    CreateProductResponse productToCreateProductResponse(Product product);

    GetProductResponse productToGetProductResponse(Product product);
}
