package com.example.H2HBackend.repositories;

import com.example.H2HBackend.entities.Objet;
import com.example.H2HBackend.enums.EtatObjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ObjetReporsitory extends JpaRepository<Objet,Long> {
    List<Objet> findByEtatObjet(EtatObjet etatObjet);
    List<Objet> findByEstReserveFalse();
    List<Objet> findByCategorie_IdCategorie(Long idCategorie);
}
