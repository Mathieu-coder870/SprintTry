package fr.simplon.domedespuys.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.entities.Product;
import fr.simplon.domedespuys.repository.ProductRepository;
import fr.simplon.domedespuys.service.interfaces.IProductService;
import fr.simplon.domedespuys.views.ProductView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductRestController {
    private IProductService productService;

    @GetMapping
    @JsonView(ProductView.ProductListView.class)
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @GetMapping("/slug/{slug}")
    @JsonView(ProductView.ProductDetailView.class)
    public List<Product> getProductsBySlug(@PathVariable String slug) {
        return productService.findProductBySlug(slug);
    }

    @GetMapping("/{id}")
    @JsonView(ProductView.ProductDetailView.class)
    public Optional<Product> getProduct(@PathVariable String id) {
        return productService.findById(Long.valueOf(id));
    }
}

