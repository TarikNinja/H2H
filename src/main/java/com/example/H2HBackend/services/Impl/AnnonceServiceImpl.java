package com.example.H2HBackend.services.Impl;

import com.example.H2HBackend.entities.Annonce;
import com.example.H2HBackend.repositories.AnnonceRepository;
import com.example.H2HBackend.services.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnonceServiceImpl implements AnnonceService {
    @Autowired
    private AnnonceRepository annonceRepository;

    @Override
    public Annonce addAnnonce(Annonce annonce) {
        return annonceRepository.save(annonce);
    }

    @Override
    public Annonce updateAnnonce(Long idAnnonce, Annonce updatedAnnonce) {
        Annonce existingAnnonce = annonceRepository.findById(idAnnonce)
                .orElseThrow(() -> new IllegalArgumentException("Annonce not found with ID: " + idAnnonce));

        existingAnnonce.setTitreAnnonce(updatedAnnonce.getTitreAnnonce());
        existingAnnonce.setDescription(updatedAnnonce.getDescription());
        existingAnnonce.setDatePub(updatedAnnonce.getDatePub());
        existingAnnonce.setType(updatedAnnonce.getType());
        existingAnnonce.setUser(updatedAnnonce.getUser());
        existingAnnonce.setEmplacement(updatedAnnonce.getEmplacement());
        existingAnnonce.setObjet(updatedAnnonce.getObjet());

        return annonceRepository.save(existingAnnonce);
    }

    @Override
    public void deleteAnnonce(Long idAnnonce) {
        if (!annonceRepository.existsById(idAnnonce)) {
            throw new IllegalArgumentException("Annonce not found with ID: " + idAnnonce);
        }
        annonceRepository.deleteById(idAnnonce);
    }

    @Override
    public List<Annonce> getAllAnnonces() {
        return annonceRepository.findAll();
    }

    @Override
    public Annonce getAnnonceById(Long idAnnonce) {
        return annonceRepository.findById(idAnnonce)
                .orElseThrow(() -> new IllegalArgumentException("Annonce not found with ID: " + idAnnonce));
    }

    @Override
    public List<Annonce> getAnnoncesByUser(Long idUser) {
        return annonceRepository.findByUserId(idUser);
    }

    @Override
    public List<Annonce> searchAnnonces(String keyword) {
        return annonceRepository.findByTitreAnnonceContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword);
    }
}
