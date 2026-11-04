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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(length = 20, unique = true, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String password;

    @Column(length = 45, nullable = false)
    private String firstname;

    @Column(length = 45,  nullable = false)
    private String lastname;

    @Column(length = 20)
    private String phone;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    List<Address> addresses;

    @OneToMany(mappedBy = "user")
    List<Purchase> purchases;
}
