package kodlama.io.ecommerce.business.dto.requests;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import kodlama.io.ecommerce.entities.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductRequest {
    private String name;
    private int quantity;
    private double unitPrice;
    private String description;
    private Status status;
}
