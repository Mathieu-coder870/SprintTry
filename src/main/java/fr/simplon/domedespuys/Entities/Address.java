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

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 55,  nullable = false)
    private String line;

    @Column(length = 20,  nullable = true)
    private String extraLine;

    @Column(length = 20,  nullable = false)
    private String zipCode;

    @Column(length = 20,  nullable = false)
    private String country;

    @Column(length = 20)
    private String phone;

    @Column(length = 20, nullable = false)
    private String firstname;

    @Column(length = 20,  nullable = false)
    private String lastname;

    @Column( nullable = false)
    private LocalDateTime CreatedAt;

    @ManyToOne(optional = false)
            @JoinColumn(nullable = false)
    private User user;

}
