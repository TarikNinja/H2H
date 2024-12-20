package com.example.H2HBackend.services;

import com.example.H2HBackend.entities.Annonce;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnnonceService {

    Annonce addAnnonce(Annonce annonce);
    Annonce updateAnnonce(Long idAnnonce, Annonce updatedAnnonce);
    void deleteAnnonce(Long idAnnonce);
    List<Annonce> getAllAnnonces();
    Annonce getAnnonceById(Long idAnnonce);
    List<Annonce> getAnnoncesByUser(Long idUser);
    List<Annonce> searchAnnonces(String keyword);
}
