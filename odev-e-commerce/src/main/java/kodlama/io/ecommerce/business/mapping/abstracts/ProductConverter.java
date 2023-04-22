package kodlama.io.ecommerce.business.mapping.abstracts;

import kodlama.io.ecommerce.business.dto.requests.UpdateProductRequest;
import kodlama.io.ecommerce.business.dto.requests.create.CreateProductRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateProductResponse;
import kodlama.io.ecommerce.business.dto.responses.get.ProductDTO;
import kodlama.io.ecommerce.entities.Product;

public interface ProductConverter {
    Product createProductRequestToProduct(CreateProductRequest createProductRequest);

    CreateProductResponse productToCreateProductResponse(Product product);

    ProductDTO productToGetProductResponse(Product product);

    void updateProductRequestToProduct(UpdateProductRequest updateProductRequest, Product product);
}
