package kodlama.io.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Basket {


    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Product> products=new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public Long calculateTotalPrice(){
        return products.stream().map(Product::getUnitPrice).count();
    }


}
