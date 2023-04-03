package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.business.dto.CategoryDto;
import kodlama.io.ecommerce.business.dto.requests.create.CreateProductRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateProductResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllProductResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetProductResponse;
import kodlama.io.ecommerce.business.mapping.abstracts.ProductConverter;
import kodlama.io.ecommerce.entities.Category;
import kodlama.io.ecommerce.entities.Product;
import kodlama.io.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private final ProductRepository repository;
    private final ProductConverter productConverter;


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
    public Product update(Product product, int id) {
        validateProduct(product);
        product.setId(product.getId());
        return repository.save(product);
    }

    @Override
    public List<GetAllProductResponse> getAll() {
        List<Product> products = repository.findAll();
        List<GetAllProductResponse> productDtoList = new ArrayList<>();
        for (Product product : products) {
            GetAllProductResponse response = new GetAllProductResponse();
            response.setName(product.getName());
            response.setId(product.getId());
            response.setDescription(product.getDescription());
            response.setUnitPrice(product.getUnitPrice());
            response.setStatus(product.getStatus());
            response.setQuantity(product.getQuantity());
            productDtoList.add(response);
        }
        return productDtoList;
    }

    @Override
    public GetProductResponse getById(int id) {
        Product product = repository.getById(id);
        if (product == null) {
            return null;
        }
        GetProductResponse response = new GetProductResponse();
        productConverter.productToCreateProductResponse(product);


        List<Category> categories = product.getCategories().stream().toList();
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        if (!categories.isEmpty()) {
            for (Category category : categories) {
                CategoryDto categoryDto = new CategoryDto();
                categoryDto.setName(category.getName());
                categoryDto.setId(category.getId());
                categoryDtoList.add(categoryDto);
            }
            response.setCategoryList(categoryDtoList);
        }

        return response;
    }


    private void checkIfDescriptionLengthValid(Product product) {
        if (product.getDescription().length() < 10 || product.getDescription().length() > 50)
            throw new IllegalArgumentException("Description length must be between 10 and 50 characters");
    }

    private void validateProduct(Product product) {

        checkIfDescriptionLengthValid(product);
    }

}
