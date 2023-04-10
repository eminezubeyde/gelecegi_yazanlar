package kodlama.io.rentacar.business.dto.requests.create;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateRentalRequest {
    private int carId;
    private double dailyPrice;
    private int rentedForDays;
}
