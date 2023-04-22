package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.business.dto.requests.create.CreateCategoryRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateCategoryResponse;
import kodlama.io.ecommerce.business.dto.responses.get.CategoryDto;
import kodlama.io.ecommerce.business.dto.responses.get.GetCategoryResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateCategoryResponse;
import kodlama.io.ecommerce.entities.Category;

import java.util.List;

public interface CategoryService {
    GetCategoryResponse getById();
    List<CategoryDto> getAll();

    CreateCategoryResponse add(CreateCategoryRequest request);
    void delete (int id);
    UpdateCategoryResponse update(int id, Category category);
}
