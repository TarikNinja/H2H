package com.example.H2HBackend.repositories;

import com.example.H2HBackend.entities.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce,Long> {
    @Query("SELECT a FROM Annonce a WHERE a.user.idUser = :idUser")
    List<Annonce> findByUserId(@Param("idUser") Long idUser);
    List<Annonce> findByTitreAnnonceContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String keyword, String keyword1);
}
