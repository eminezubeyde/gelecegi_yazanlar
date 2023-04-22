package kodlama.io.ecommerce.business;

import kodlama.io.ecommerce.entities.Address;
import kodlama.io.ecommerce.business.dto.AddressDTO;
import org.springframework.stereotype.Service;

@Service
public class CustomerConverterImpl implements CustomerConverter {
    @Override
    public Address dtoToEntity(AddressDTO invoiceAddress) {
            Address address=new Address();
            address.setNo(invoiceAddress.getNo());
            address.setCity(invoiceAddress.getCity());
            address.setCountry(invoiceAddress.getCountry());
            address.setStreet(invoiceAddress.getStreet());
            address.setDistrict(invoiceAddress.getDistrict());
            return address;
    }
}
