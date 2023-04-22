package kodlama.io.ecommerce.business;

import kodlama.io.ecommerce.entities.Address;
import kodlama.io.ecommerce.business.dto.AddressDTO;

public interface CustomerConverter {


    Address dtoToEntity(AddressDTO invoiceAddress);
}