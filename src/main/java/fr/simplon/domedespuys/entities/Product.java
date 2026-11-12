package fr.simplon.domedespuys.entities;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.views.ProductView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80, unique = true, nullable = false)
    private String label;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String description;

    @Column(length = 10, nullable = false)
    private int price;

    @Column(length = 80, unique = true, nullable = false)
    private String slug;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "product")
    List<PurchaseProduct> purchaseProducts;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Brand brand;


    @OneToMany(mappedBy = "product")
    List<Image> images;

    public void addImage(Image image) {
        images.add(image);
        image.setProduct(this);
    }

    @JsonView(ProductView.MainImage.class)
    public Image getMainImage() {
        for (Image image : images) {
            if (image.isDefault()) {
                return image;
            }
        }
        return null;
    }
}
