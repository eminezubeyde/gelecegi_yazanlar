package kodlama.io.ecommerce.business.mapping.concretes;

import kodlama.io.ecommerce.business.dto.requests.create.CreateProductRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateProductResponse;
import kodlama.io.ecommerce.business.mapping.abstracts.ProductConverter;
import kodlama.io.ecommerce.entities.Product;
import kodlama.io.ecommerce.entities.enums.Status;
import org.springframework.stereotype.Component;

@Component
public class ProductConverterImpl implements ProductConverter {
    @Override
    public Product createProductRequestToProduct(CreateProductRequest createProductRequest) {
        Product product=new Product();
        product.setQuantity(createProductRequest.getQuantity());
        product.setName(createProductRequest.getName());
        product.setDescription(createProductRequest.getDescription());
        product.setUnitPrice(createProductRequest.getUnitPrice());
        product.setStatus(Status.AVAILABLE);

        return product;
    }

    @Override
    public CreateProductResponse productToCreateProductResponse(Product product) {
        CreateProductResponse response=new CreateProductResponse();
        response.setId(product.getId());
        response.setDescription(product.getDescription());
        response.setQuantity(product.getQuantity());
        response.setStatus(product.getStatus());
        response.setName(product.getName());
        response.setUnitPrice(product.getUnitPrice());
        return response;
    }
}
