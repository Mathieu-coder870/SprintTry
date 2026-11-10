package controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.views.BrandView;
import fr.simplon.domedespuys.entities.Brand;
import fr.simplon.domedespuys.repository.BrandRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/api/brand")
public class BrandRestController {

    private final BrandRepository brandRepository;

    public  BrandRestController(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }

    @GetMapping()
    public List<Brand> getBrands(){
        return  brandRepository.findAll();
    }

    @GetMapping("/slug/{slug}")
    @JsonView(BrandView.BrandDetailView.class)
    public Optional<Brand> getBranchBySlug(@PathVariable String slug) {
        return brandRepository.findBySlug(slug);
    }


    @GetMapping("/{id}")
    @JsonView(BrandView.BrandDetailView.class)
    public Optional<Brand> getBrandById(@PathVariable String id) {
        return brandRepository.findById(Long.valueOf(id));
    }
}
