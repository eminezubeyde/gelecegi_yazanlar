package kodlama.io.ecommerce.business.dto.responses.create;

import kodlama.io.ecommerce.business.dto.responses.get.CategoryDto;
import kodlama.io.ecommerce.entities.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CreateProductResponse {
    private int id;
    private String name;
    private int quantity;
    private double unitPrice;
    private String description;
    private Status status;
    private List<CategoryDto> categoryList;
}
