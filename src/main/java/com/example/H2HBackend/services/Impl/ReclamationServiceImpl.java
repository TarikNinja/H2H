package com.example.H2HBackend.services.Impl;

import com.example.H2HBackend.entities.Reclamation;
import com.example.H2HBackend.entities.User;
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
        return reclamationRepository.save(reclamation);
    }

    @Override
    public Reclamation updateReclamation(Long idReclamation, Reclamation updatedReclamation) {
        Reclamation existReclamation = reclamationRepository.findById(idReclamation).orElse(null);
        if (existReclamation == null) {
            return null;
        }
        else {
            existReclamation.setObjetReclamation(updatedReclamation.getObjetReclamation());
            existReclamation.setDateReclamation(updatedReclamation.getDateReclamation());
            existReclamation.setDescription(updatedReclamation.getDescription());
            existReclamation.setUser(updatedReclamation.getUser());
            return reclamationRepository.save(existReclamation);
        }
    }

    @Override
    public void deleteReclamation(Long idReclamation) {
        reclamationRepository.deleteById(idReclamation);
    }

    @Override
    public List<Reclamation> getAllReclamations() {
        return reclamationRepository.findAll();
    }

    @Override
    public Reclamation getReclamationById(Long idReclamation) {
        return reclamationRepository.findById(idReclamation).orElse(null);
    }

    @Override
    public List<Reclamation> getReclamationsByUserId(Long idUser) {
        User user=userRepository.findById(idUser).orElse(null);
        assert user != null;
        user.setNbReclamations(user.getNbReclamations()+1);
        return reclamationRepository.findReclamationByUser(idUser);
    }

    @Override
    public List<Reclamation> getReclamationsByObjet(ObjetReclamation objetReclamation) {
        return reclamationRepository.findReclamationByObjetReclamation(objetReclamation);
    }

    @Override
    public List<Reclamation> getReclamationsByDate(LocalDate dateReclamation) {
        return reclamationRepository.findReclamationByDateReclamation(dateReclamation);
    }
}
