package kodlama.io.rentacar.business.dto.requests.create;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMaintenanceRequest {

    private String information;
    private int carId;
}
