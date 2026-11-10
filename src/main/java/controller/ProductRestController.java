package controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.entities.Product;
import fr.simplon.domedespuys.repository.ProductRepository;
import fr.simplon.domedespuys.views.ProductView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductRestController{

    private final ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping()
    public List<Product> getProducts(){
        return  productRepository.findAll();
    }

    @GetMapping("/slug/{slug}")
    @JsonView(ProductView.class)
    public Optional<Product> getProductBySlug( @PathVariable String slug){
        return productRepository.findBySlug(slug);
    }

    @GetMapping("/{id}")
    @JsonView(ProductView.ProductDetailView.class)
    public Optional<Product> getProductByID(@PathVariable String id){
        return productRepository.findById(Long.valueOf(id));
    }

}
