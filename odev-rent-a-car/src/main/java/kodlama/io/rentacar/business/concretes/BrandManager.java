package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.BrandService;
import kodlama.io.rentacar.entities.Brand;
import kodlama.io.rentacar.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getById(int id) {
        return brandRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("böyle bir marka mevcut değildir"));
    }

    @Override
    public Brand add(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand update(int id, Brand brand) {
        brand.setId(id);
        return brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }

    //business rules
    private void checkIfBrandExists(int id) {
        if (!brandRepository.existsById(id)) throw new IllegalArgumentException("böyle bir marka mevcut değildir");
    }
}
