package com.example.H2HBackend.entities;

import com.example.H2HBackend.enums.typeAnnonce;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnnonce;

    @Enumerated(EnumType.STRING)
    private typeAnnonce type;

    private String titreAnnonce;

    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @Temporal(TemporalType.DATE)
    private Date datePub;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "idEmplacement", referencedColumnName = "idEmplacement")
    private Emplacement emplacement;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "idObjet", referencedColumnName = "idObjet")
    private Objet objet;
}

