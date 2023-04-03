package kodlama.io.ecommerce.api.controllers;

import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateProductRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateProductResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllProductResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetProductResponse;
import kodlama.io.ecommerce.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value= "products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("getAll")
    public List<GetProductResponse> getAll() {
        return productService.getAll();
    }

    @GetMapping("getById") // end pointlerin isimlerini değiştir.
    public GetProductResponse getById(@RequestParam(name = "productId",required = false) int id) {
        return productService.getById(id);
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse create(@RequestBody CreateProductRequest createProductRequest) {
        return productService.add(createProductRequest);

    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }

    @PutMapping("update/{id}")
    public Product update(@RequestBody Product product, @PathVariable int id) {
        return productService.update(product, id);
    }

}
