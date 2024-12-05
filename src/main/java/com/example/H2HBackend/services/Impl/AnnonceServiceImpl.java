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
    public Annonce updateAnnonce(int idAnnonce, Annonce updatedAnnonce) {
        Annonce existingAnnonce = annonceRepository.findById(idAnnonce)
                .orElseThrow(() -> new IllegalArgumentException("Annonce not found"));

        existingAnnonce.setTitreAnnonce(updatedAnnonce.getTitreAnnonce());
        existingAnnonce.setDescription(updatedAnnonce.getDescription());
        existingAnnonce.setDatePub(updatedAnnonce.getDatePub());
        existingAnnonce.setType(updatedAnnonce.getType());
        existingAnnonce.setEtat(updatedAnnonce.getEtat());
        existingAnnonce.setCategorie(updatedAnnonce.getCategorie());
        existingAnnonce.setUser(updatedAnnonce.getUser());
        existingAnnonce.setEmplacement(updatedAnnonce.getEmplacement());
        existingAnnonce.setImages(updatedAnnonce.getImages());

        return annonceRepository.save(existingAnnonce);
    }

    @Override
    public void deleteAnnonce(int idAnnonce) {
        if (!annonceRepository.existsById(idAnnonce)) {
            throw new IllegalArgumentException("Annonce not found");
        }
        annonceRepository.deleteById(idAnnonce);
    }

    @Override
    public List<Annonce> getAllAnnonces() {
        return annonceRepository.findAll();
    }

    @Override
    public Annonce getAnnonceById(int idAnnonce) {
        return annonceRepository.findById(idAnnonce)
                .orElseThrow(() -> new IllegalArgumentException("Annonce not found"));
    }

    @Override
    public List<Annonce> getAnnoncesByUser(Long idUser) {
        return annonceRepository.findByUserId(idUser);
    }

    @Override
    public List<Annonce> getAnnoncesByCategorie(Long idCategorie) {
        return annonceRepository.findByCategorieId(idCategorie);
    }

    @Override
    public List<Annonce> searchAnnonces(String keyword) {
        return annonceRepository.findByTitreAnnonceContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword);
    }

    @Override
    public void reserveAnnonce(int idAnnonce) {
        Annonce annonce = annonceRepository.findById(idAnnonce)
                .orElseThrow(() -> new IllegalArgumentException("Annonce not found"));
        annonce.setEstReserve(true);
        annonceRepository.save(annonce);
    }

    @Override
    public void unreserveAnnonce(int idAnnonce) {
        Annonce annonce = annonceRepository.findById(idAnnonce)
                .orElseThrow(() -> new IllegalArgumentException("Annonce not found"));
        annonce.setEstReserve(false);
        annonceRepository.save(annonce);
    }
}
