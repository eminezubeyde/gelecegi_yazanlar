package kodlama.io.rentacar.business.dto.responses.get.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetModelResponse {
    private int id;
    private int brandId;
    private String name;
}
