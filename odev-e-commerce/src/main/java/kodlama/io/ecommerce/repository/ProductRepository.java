package kodlama.io.ecommerce.repository;

import kodlama.io.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Integer> {

        @Query(nativeQuery = true,value = "Select * from product where id=?1")
        Product getById(int id);//gönderilen id ye göre product döner
}
