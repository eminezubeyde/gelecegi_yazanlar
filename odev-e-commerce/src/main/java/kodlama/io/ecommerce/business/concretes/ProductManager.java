package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateProductRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateProductResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllProductResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetCategoryResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetProductResponse;
import kodlama.io.ecommerce.business.mapping.abstracts.CategoryConverter;
import kodlama.io.ecommerce.business.mapping.abstracts.ProductConverter;
import kodlama.io.ecommerce.entities.Category;
import kodlama.io.ecommerce.entities.Product;
import kodlama.io.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public Product update(Product product, int id) {
        validateProduct(product);
        product.setId(product.getId());
        return repository.save(product);
    }

    @Override
    public List<GetProductResponse> getAll() {
        /*
       List<Product> productList=repository.findAll();
       List<GetProductResponse> responseList=new ArrayList<>();
       for( Product x: productList){
           GetProductResponse response=productConverter.productToGetProductResponse(product);
           responseList.add(response);
       }
         */



       return repository.findAll().stream().map(productConverter::productToGetProductResponse).toList();

    }

    @Override
    public GetProductResponse getById(int id) {
        Product product = repository.getById(id);
        if (product == null) {
            return null;
        }
        return productConverter.productToGetProductResponse(product);
    }


    private void checkIfDescriptionLengthValid(Product product) {
        if (product.getDescription().length() < 10 || product.getDescription().length() > 50)
            throw new IllegalArgumentException("Description length must be between 10 and 50 characters");
    }

    private void validateProduct(Product product) {

        checkIfDescriptionLengthValid(product);
    }

}
