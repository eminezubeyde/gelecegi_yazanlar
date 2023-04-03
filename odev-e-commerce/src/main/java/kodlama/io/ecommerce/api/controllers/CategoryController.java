package kodlama.io.ecommerce.api.controllers;

import kodlama.io.ecommerce.business.abstracts.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/category")
@AllArgsConstructor
public class CategoryController {
    private CategoryService service;

}
