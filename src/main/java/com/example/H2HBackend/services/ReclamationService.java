package com.example.H2HBackend.services;

import com.example.H2HBackend.entities.Reclamation;
import com.example.H2HBackend.enums.ObjetReclamation;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface ReclamationService {
    Reclamation createReclamation(Reclamation reclamation);

    Reclamation updateReclamation(Long idReclamation, Reclamation updatedReclamation);

    void deleteReclamation(Long idReclamation);

    List<Reclamation> getAllReclamations();

    Reclamation getReclamationById(Long idReclamation);

    List<Reclamation> getReclamationsByUserId(Long idUser);

    List<Reclamation> getReclamationsByObjet(ObjetReclamation objetReclamation);

    List<Reclamation> getReclamationsByDate(LocalDate dateReclamation);
}


