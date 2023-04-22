package kodlama.io.ecommerce.business.dto.responses.get;

import kodlama.io.ecommerce.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private int id;
    private String name;
    private int quantity;
    private double unitPrice;
    private String description;
    private Status status;
    private List<GetCategoryResponse> categoryList;
}
