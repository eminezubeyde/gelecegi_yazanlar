package kodlama.io.rentacar.api.controllers;

import kodlama.io.rentacar.business.abstracts.ModelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/models/")
public class ModelsController {
    private final ModelService modelService;

}
