package com.example.H2HBackend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorie;
    @Column(unique = true)
    private String nomCategorie;

    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    private List<Annonce> annonces;
}
