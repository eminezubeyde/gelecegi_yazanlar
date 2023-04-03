package kodlama.io.ecommerce.business.dto.responses.update;

import kodlama.io.ecommerce.business.dto.responses.get.GetCategoryResponse;
import kodlama.io.ecommerce.entities.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UpdateProductResponse {
    private int id;
    private String name;
    private int quantity;
    private double unitPrice;
    private String description;
    private Status status;
    private List<GetCategoryResponse> categoryList;
}
