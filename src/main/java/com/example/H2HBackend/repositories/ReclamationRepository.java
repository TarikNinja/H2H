package com.example.H2HBackend.repositories;

import com.example.H2HBackend.entities.Reclamation;
import com.example.H2HBackend.enums.ObjetReclamation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ReclamationRepository extends JpaRepository<Reclamation,Long> {
    List<Reclamation> findReclamationByUser(Long idUser);
    List<Reclamation> findReclamationByObjetReclamation(ObjetReclamation objetReclamation);
    List<Reclamation> findReclamationByDateReclamation(LocalDate dateReclamation);
}
