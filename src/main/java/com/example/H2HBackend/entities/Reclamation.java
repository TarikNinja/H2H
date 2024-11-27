package com.example.H2HBackend.entities;

import com.example.H2HBackend.enums.ObjetReclamation;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.time.LocalDateTime;

public class Reclamation {
    private Long idReclamation;
    private ObjetReclamation objetReclamation;
    @Column(columnDefinition = "LONGTEXT")
    private String description;
    @Temporal(TemporalType.DATE)
    private LocalDateTime dateReclamation;
}
