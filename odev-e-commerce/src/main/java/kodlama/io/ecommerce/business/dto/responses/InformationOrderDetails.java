package kodlama.io.ecommerce.business.dto.responses;

import kodlama.io.ecommerce.business.dto.AddressDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InformationOrderDetails {

    private AddressDTO orderAddress;

    private AddressDTO invoiceAddress;

    private Long totalPrice;

    private LocalDateTime date;

}
