package com.example.H2HBackend.services.Impl;

import com.example.H2HBackend.entities.Attachment;
import com.example.H2HBackend.entities.Objet;
import com.example.H2HBackend.enums.EtatObjet;
import com.example.H2HBackend.repositories.ObjetReporsitory;
import com.example.H2HBackend.services.AttachmentService;
import com.example.H2HBackend.services.ObjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class ObjetServiceImpl implements ObjetService {
    @Autowired
    private ObjetReporsitory objetReporsitory;
    @Autowired
    private AttachmentService attachmentService;


    @Override
    public Objet createObjet(Objet objet, MultipartFile file1, MultipartFile file2, MultipartFile file3, MultipartFile file4, MultipartFile file5, MultipartFile file6) {
        Attachment firstimage = attachmentService.createAttachment(file1);
        objet.setImage2(firstimage);
        Attachment secondimage = attachmentService.createAttachment(file2);
        objet.setImage2(secondimage);
        Attachment thirdimage = attachmentService.createAttachment(file3);
        objet.setImage3(thirdimage);
        Attachment fourthimage = attachmentService.createAttachment(file4);
        objet.setImage4(fourthimage);
        Attachment fifthimage = attachmentService.createAttachment(file5);
        objet.setImage5(fifthimage);
        Attachment sixthimage = attachmentService.createAttachment(file6);
        objet.setImage6(sixthimage);
        return objetReporsitory.save(objet);
    }

    @Override
    public Optional<Objet> getObjetById(Long idObjet) {
        return objetReporsitory.findById(idObjet);
    }

    @Override
    public List<Objet> getAllObjets() {
        return objetReporsitory.findAll();
    }

    @Override
    public Objet updateObjet(Long idObjet, Objet updatedObjet) {
        Objet existingObjet = objetReporsitory.findById(idObjet)
                .orElseThrow(() -> new IllegalArgumentException("Objet not found"));
        existingObjet.setEtatObjet(updatedObjet.getEtatObjet());
        existingObjet.setEstReserve(updatedObjet.isEstReserve());
        existingObjet.setCategorie(updatedObjet.getCategorie());
        existingObjet.setImages(updatedObjet.getImages());
        return objetReporsitory.save(existingObjet);
    }

    @Override
    public void deleteObjet(Long idObjet) {
        if (!objetReporsitory.existsById(idObjet)) {
            throw new IllegalArgumentException("Objet not found");
        }
        objetReporsitory.deleteById(idObjet);
    }

    // Implémentation des nouvelles méthodes

    @Override
    public List<Objet> findByEtatObjet(EtatObjet etatObjet) {
        return objetReporsitory.findByEtatObjet(etatObjet);
    }

    @Override
    public List<Objet> findAvailableObjets() {
        return objetReporsitory.findByEstReserveFalse();
    }

    @Override
    public List<Objet> findByCategorie(Long idCategorie) {
        return objetReporsitory.findByCategorie_IdCategorie(idCategorie);
    }

    @Override
    public Objet reserveObjet(Long idObjet) {
        Objet objet = objetReporsitory.findById(idObjet)
                .orElseThrow(() -> new IllegalArgumentException("Objet not found"));
        objet.setEstReserve(true);
        return objetReporsitory.save(objet);
    }

    @Override
    public Objet cancelReservation(Long idObjet) {
        Objet objet = objetReporsitory.findById(idObjet)
                .orElseThrow(() -> new IllegalArgumentException("Objet not found"));
        objet.setEstReserve(false);
        return objetReporsitory.save(objet);
    }
}
