package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.BrandDTO;
import fr.simplon.domedespuys.dto.ProductDTO;
import fr.simplon.domedespuys.dto.ImageDTO;
import fr.simplon.domedespuys.utils.Slugger;
import fr.simplon.domedespuys.entities.Image;
import fr.simplon.domedespuys.entities.Product;
import fr.simplon.domedespuys.repository.ProductRepository;
import fr.simplon.domedespuys.service.interfaces.IBrandService;
import fr.simplon.domedespuys.service.interfaces.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private ProductRepository productRepository;
    private IBrandService brandService;
    private Slugger slugger;
    @Override
    public List<Product> getCollection() {
        return productRepository.findAll();
    }

    @Override
    public Product create(ProductDTO dto) {
        Product product = new Product();
        product.setLabel(dto.label);
        product.setDescription(dto.description);
        product.setPrice(dto.price);
        product.setCreatedAt(LocalDateTime.now());
        product.setBrand(brandService.getById(dto.brandId));
        return null;
    }

    @Override
    public Product getById(String id) {
        return productRepository.findById(Long.parseLong(id)).orElse(null);
    }

    @Override
    public ProductDTO update(String id, ProductDTO dto) {
        Product product = getById(id);
        if (Product != null) {
            dtoToObject(dto, product);
        }
        return product;
    }
      private void dtoToObject(ProductDTO dto, Product product) {
        product.setLabel(dto.label);
        product.setDescription(dto.description);
        product.setPrice(dto.price);
        product.setImages(dto.images);
        product.setSlug(slugger.slugify(dto.label));
        productRepository.saveAndFlush(product);
    }

}
