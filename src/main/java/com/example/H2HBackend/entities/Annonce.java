package com.example.H2HBackend.entities;

import com.example.H2HBackend.enums.etatObjet;
import com.example.H2HBackend.enums.typeAnnonce;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Data
@Builder @ToString
public class Annonce {
    @Id
    private int idAnnonce;
    private typeAnnonce type;
    private String titreAnnonce;
    @Column(columnDefinition = "LONGTEXT")
    private String Description;
    private etatObjet etat;
    @Temporal(TemporalType.DATE)
    private Date datePub;
    private boolean estReserve;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Attachment images[];

    @ManyToOne
    @JoinColumn(name = "idCategorie")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEmplacement", referencedColumnName = "idEmplacement")
    private Emplacement emplacement;



}
