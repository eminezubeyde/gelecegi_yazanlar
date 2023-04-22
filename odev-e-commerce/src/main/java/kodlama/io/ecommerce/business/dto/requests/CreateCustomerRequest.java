package kodlama.io.ecommerce.business.dto.requests;

import lombok.Data;

@Data
public class CreateCustomerRequest {
    private String name;
    private String email;
}
