package kodlama.io.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import kodlama.io.ecommerce.entities.enums.Status;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;
    private double unitPrice;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Category> categories = new HashSet<>();
}
