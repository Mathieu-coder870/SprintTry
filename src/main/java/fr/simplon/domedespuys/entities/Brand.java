package fr.simplon.domedespuys.entities;


import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.views.BrandView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(BrandView.Id.class)
    private Long id;

    @Column(length = 64, unique = true, nullable = false)
    private String label;

    @Column( columnDefinition = "TEXT")
    private String logo;

    @Column(length = 64,  nullable = false)
    private String slug;

    @OneToMany(mappedBy = "brand")
    List<Product> products;

}
