package com.example.H2HBackend.entities;


import com.example.H2HBackend.enums.EtatObjet;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class Objet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idObjet;

    @Enumerated(EnumType.STRING)
    private EtatObjet etatObjet;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Attachment[] images;

    private boolean estReserve;

    @ManyToOne
    @JoinColumn(name = "idCategorie")
    private Categorie categorie;

    @OneToOne(mappedBy = "objet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Annonce annonce;
}


