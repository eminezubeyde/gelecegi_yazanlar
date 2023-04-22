package kodlama.io.ecommerce.business.dto;

import lombok.Data;

@Data
public class AddressDTO {

    private String country;
    private String city;
    private String district;
    private String street;
    private String no;
}
