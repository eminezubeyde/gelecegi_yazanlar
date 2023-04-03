package kodlama.io.ecommerce.business.dto.responses.get;

import kodlama.io.ecommerce.business.dto.CategoryDto;
import kodlama.io.ecommerce.entities.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllProductResponse {
    private int id;
    private String name;
    private int quantity;
    private double unitPrice;
    private String description;
    private Status status;
    private List<CategoryDto> categoryList;
}
