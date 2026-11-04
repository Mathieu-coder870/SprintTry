package fr.simplon.domedespuys.Entities;


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
    private Long id;

    @Column(length = 20, unique = true, nullable = false)
    private String label;

    @Column(length = 20, unique = true, nullable = true)
    private String logo;

    @Column(length = 20, unique = true, nullable = false)
    private String slug;

    @OneToMany(mappedBy = "brand")
    List<Product> products;

}
