package kodlama.io.rentacar.adapters;

import kodlama.io.rentacar.business.abstracts.PosService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FakePosServiceAdapter implements PosService {
    @Override
    public void pay() {
        boolean isPaymentsSuccessful=new Random().nextBoolean();
        if(!isPaymentsSuccessful) throw new RuntimeException("ödeme başarısız oldu");
    }
}
