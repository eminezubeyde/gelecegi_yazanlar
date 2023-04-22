package kodlama.io.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Invoice {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    private Long totalPrice;
    // ödeme bilgileri.

    @OneToOne(cascade = CascadeType.ALL)
    private Address orderAddress;

    @OneToOne(cascade = CascadeType.ALL)
    private Address invoiceAddress;

    private LocalDate createdDate;




}
