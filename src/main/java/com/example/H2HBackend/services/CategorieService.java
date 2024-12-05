package com.example.H2HBackend.services;

import com.example.H2HBackend.entities.Categorie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategorieService {
    Categorie addCategorie(Categorie categorie);
    List<Categorie> getAllCategories();
    Categorie getCategorieById(Long id);
    Categorie updateCategorie(Long id, Categorie updatedCategorie);
    void deleteCategorie(Long id);
}
