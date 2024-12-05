package com.example.H2HBackend.repositories;

import com.example.H2HBackend.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Long> {
    Optional<Categorie> findByNomCategorie(String nomCategorie);
}
