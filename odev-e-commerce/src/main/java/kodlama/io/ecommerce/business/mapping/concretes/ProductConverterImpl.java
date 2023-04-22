package kodlama.io.ecommerce.business.mapping.concretes;

import kodlama.io.ecommerce.business.dto.requests.UpdateProductRequest;
import kodlama.io.ecommerce.business.dto.requests.create.CreateProductRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateProductResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetCategoryResponse;
import kodlama.io.ecommerce.business.dto.responses.get.ProductDTO;
import kodlama.io.ecommerce.business.mapping.abstracts.CategoryConverter;
import kodlama.io.ecommerce.business.mapping.abstracts.ProductConverter;
import kodlama.io.ecommerce.entities.Category;
import kodlama.io.ecommerce.entities.Product;
import kodlama.io.ecommerce.entities.enums.Status;
import kodlama.io.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductConverterImpl implements ProductConverter {

    private final CategoryConverter categoryConverter;
    private final ProductRepository productRepository;

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

    @Override
    public ProductDTO productToGetProductResponse(Product product) {
        ProductDTO response=new ProductDTO();
        response.setId(product.getId());
        response.setDescription(product.getDescription());
        response.setQuantity(product.getQuantity());
        response.setStatus(product.getStatus());
        response.setName(product.getName());
        response.setUnitPrice(product.getUnitPrice());

        List<Category> categories = product.getCategories().stream().toList();
        List<GetCategoryResponse> categoryResponseList = new ArrayList<>();
        if (!categories.isEmpty()) {
            for (Category category : categories) {
                GetCategoryResponse categoryResponse = categoryConverter.categoryToGetCategoryResponse(category);

                categoryResponseList.add(categoryResponse);
            }
            response.setCategoryList(categoryResponseList);
        }

        return response;
    }

    @Override
    public void updateProductRequestToProduct(UpdateProductRequest updateProductRequest, Product product) {

    }
}
