package kodlama.io.ecommerce.business.dto.requests.create;

import jakarta.validation.constraints.Min;
import kodlama.io.ecommerce.entities.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequest {
    private String name;
    @Min(value =0,message = "Quantity cannot be less than zero")
    private int quantity;
    @Min(value =0,message = "price cannot be less than or equal to zero")
    private double unitPrice;
    private String description;

}
