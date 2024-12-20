package com.example.H2HBackend.services.Impl;

import com.example.H2HBackend.entities.Reclamation;
import com.example.H2HBackend.enums.ObjetReclamation;
import com.example.H2HBackend.repositories.ReclamationRepository;
import com.example.H2HBackend.repositories.UserRepository;
import com.example.H2HBackend.services.ReclamationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

@AllArgsConstructor
public class ReclamationServiceImpl implements ReclamationService {

    @Autowired
    private final ReclamationRepository  reclamationRepository;
    @Autowired
    private final UserRepository userRepository;


    @Override
    public Reclamation createReclamation(Reclamation reclamation) {
        return null;
    }

    @Override
    public Reclamation updateReclamation(Long idReclamation, Reclamation updatedReclamation) {
        return null;
    }

    @Override
    public void deleteReclamation(Long idReclamation) {

    }

    @Override
    public List<Reclamation> getAllReclamations() {
        return List.of();
    }

    @Override
    public Reclamation getReclamationById(Long idReclamation) {
        return null;
    }

    @Override
    public List<Reclamation> getReclamationsByUserId(Long idUser) {
        return List.of();
    }

    @Override
    public List<Reclamation> getReclamationsByObjet(ObjetReclamation objetReclamation) {
        return List.of();
    }

    @Override
    public List<Reclamation> getReclamationsByDate(LocalDate dateReclamation) {
        return List.of();
    }
}
