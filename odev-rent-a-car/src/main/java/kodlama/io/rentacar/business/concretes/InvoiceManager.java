package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.InvoiceService;
import kodlama.io.rentacar.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class InvoiceManager implements InvoiceService {
    private final InvoiceRepository repository;
}
