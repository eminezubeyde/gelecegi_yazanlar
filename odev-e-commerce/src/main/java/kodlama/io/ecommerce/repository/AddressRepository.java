package kodlama.io.ecommerce.repository;

import kodlama.io.ecommerce.entities.Address;
import kodlama.io.ecommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository <Address,Long> {
}
