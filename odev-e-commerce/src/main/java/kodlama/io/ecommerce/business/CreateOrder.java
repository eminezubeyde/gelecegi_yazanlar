package kodlama.io.ecommerce.business;

import kodlama.io.ecommerce.business.dto.AddressDTO;
import lombok.Data;

@Data
public class CreateOrder {

    private AddressDTO orderAddress;

    private AddressDTO invoiceAddress;
}
