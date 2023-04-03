package kodlama.io.ecommerce.business.mapping.concretes;

import kodlama.io.ecommerce.business.dto.responses.get.GetCategoryResponse;
import kodlama.io.ecommerce.business.mapping.abstracts.CategoryConverter;
import kodlama.io.ecommerce.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverterImpl implements CategoryConverter {

    @Override
    public GetCategoryResponse categoryToGetCategoryResponse(Category category) {
        GetCategoryResponse response=new GetCategoryResponse();
        response.setName(category.getName());
        response.setId(category.getId());
        return response;
    }
}
