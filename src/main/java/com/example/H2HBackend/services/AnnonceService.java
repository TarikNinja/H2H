package com.example.H2HBackend.services;

import com.example.H2HBackend.entities.Annonce;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AnnonceService {
    Annonce addAnnonce(Annonce annonce);
    Annonce updateAnnonce(int idAnnonce, Annonce updatedAnnonce);
    void deleteAnnonce(int idAnnonce);
    List<Annonce> getAllAnnonces();
    Annonce getAnnonceById(int idAnnonce);
    List<Annonce> getAnnoncesByUser(Long idUser);
    List<Annonce> getAnnoncesByCategorie(Long idCategorie);
    List<Annonce> searchAnnonces(String keyword);
    void reserveAnnonce(int idAnnonce);
    void unreserveAnnonce(int idAnnonce);
}
