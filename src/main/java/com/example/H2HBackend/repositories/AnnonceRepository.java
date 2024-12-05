package com.example.H2HBackend.repositories;

import com.example.H2HBackend.entities.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce,Integer> {
    List<Annonce> findByUserId(Long idUser);

    List<Annonce> findByCategorieId(Long idCategorie);

    List<Annonce> findByTitreAnnonceContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String keyword, String keyword1);
}
