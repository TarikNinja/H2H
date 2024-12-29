package com.example.H2HBackend.services;


import com.example.H2HBackend.entities.Objet;
import com.example.H2HBackend.enums.EtatObjet;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public interface ObjetService {

    Objet createObjet(Objet objet, MultipartFile file1, MultipartFile file2, MultipartFile file3, MultipartFile file4,MultipartFile file5,MultipartFile file6);
    Optional<Objet> getObjetById(Long idObjet);
    List<Objet> getAllObjets();
    Objet updateObjet(Long idObjet, Objet updatedObjet);
    void deleteObjet(Long idObjet);
    List<Objet> findByEtatObjet(EtatObjet etatObjet);
    List<Objet> findAvailableObjets();
    List<Objet> findByCategorie(Long idCategorie);
    Objet reserveObjet(Long idObjet);
    Objet cancelReservation(Long idObjet);


}
