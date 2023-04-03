package kodlama.io.ecommerce.business.mapping.abstracts;

import kodlama.io.ecommerce.business.dto.responses.get.GetCategoryResponse;
import kodlama.io.ecommerce.entities.Category;

public interface CategoryConverter {
    GetCategoryResponse categoryToGetCategoryResponse(Category category);
}
