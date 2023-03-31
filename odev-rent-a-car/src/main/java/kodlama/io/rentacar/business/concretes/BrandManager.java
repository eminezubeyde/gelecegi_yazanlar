package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.BrandService;
import kodlama.io.rentacar.business.dto.requests.create.CreateBrandRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateBrandResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllBrandsResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetBrandResponse;
import kodlama.io.rentacar.entities.Brand;
import kodlama.io.rentacar.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapper mapper;
    @Override
    public List<GetAllBrandsResponse> getAll() {

        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> responses = brands
                .stream()
                .map(brand -> mapper.map(brand, GetAllBrandsResponse.class))
                .toList();
        return responses;
    }

    @Override
    public GetBrandResponse getById(int id) {
        checkIfBrandExists(id);
        Brand brand = brandRepository.findById(id).orElseThrow();
        GetBrandResponse response = mapper.map(brand, GetBrandResponse.class);
        return response;
    }

    @Override
    public CreateBrandResponse add(CreateBrandRequest request) {
        Brand brand =mapper.map(request,Brand.class);
        brandRepository.save(brand);
        CreateBrandResponse response=mapper.map(brand,CreateBrandResponse.class);
        return response;
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
