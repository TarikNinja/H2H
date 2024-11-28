package com.example.H2HBackend.entities;

import com.example.H2HBackend.enums.ObjetReclamation;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
@ToString
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReclamation;
    private ObjetReclamation objetReclamation;
    @Column(columnDefinition = "LONGTEXT")
    private String description;
    @Temporal(TemporalType.DATE)
    private LocalDate dateReclamation;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;
}
