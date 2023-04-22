package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.CategoryService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateCategoryRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateCategoryResponse;
import kodlama.io.ecommerce.business.dto.responses.get.CategoryDto;
import kodlama.io.ecommerce.business.dto.responses.get.GetCategoryResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateCategoryResponse;
import kodlama.io.ecommerce.entities.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    @Override
    public GetCategoryResponse getById() {
        return null;
    }

    @Override
    public List<CategoryDto> getAll() {
        return null;
    }

    @Override
    public CreateCategoryResponse add(CreateCategoryRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public UpdateCategoryResponse update(int id, Category category) {
        return null;
    }
}
