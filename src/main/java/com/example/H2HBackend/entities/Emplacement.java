package com.example.H2HBackend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class Emplacement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmplacement;
    private String ville;
    private String adresse;
    private String codePostal;
    private Double latitude;
    private Double longitude;

    @OneToOne(mappedBy = "emplacement")
    private Annonce annonce;
}
