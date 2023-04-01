package kodlama.io.rentacar.business.dto.responses.create;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarResponse {
    private int modelYear;
    private String plate;
    private int state;
    private double dailyPrice;
    private int modelId;
    private int brandId;
    private String modelName;
    private String brandName;
}
