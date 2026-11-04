package fr.simplon.domedespuys.Entities;

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

    @Column(length = 20, unique = true, nullable = false)
    private String label;

    @Column(length = 20, unique = true, nullable = true)
    private String description;

    @Column(length = 10, unique = true, nullable = false)
    private int price;

    @Column(length = 20, unique = true, nullable = false)
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
}
