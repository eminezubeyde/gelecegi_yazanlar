package kodlama.io.ecommerce.api.controllers;

import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(name = "/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("getall")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("get/{id}") // end pointlerin isimlerini değiştir.
    public Product getById(@PathVariable int id) {
        return productService.getById(id);
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return productService.add(product);

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
