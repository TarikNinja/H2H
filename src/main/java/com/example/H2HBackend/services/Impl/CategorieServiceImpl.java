package com.example.H2HBackend.services.Impl;

import com.example.H2HBackend.entities.Categorie;
import com.example.H2HBackend.repositories.CategorieRepository;
import com.example.H2HBackend.services.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategorieServiceImpl implements CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;
    @Override
    public Categorie addCategorie(Categorie categorie) {
        if (categorieRepository.findByNomCategorie(categorie.getNomCategorie()).isPresent()) {
            throw new RuntimeException("Une catégorie avec ce nom existe déjà !");
        }
        return categorieRepository.save(categorie);
    }

    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie getCategorieById(Long id) {
        return categorieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catégorie introuvable !"));
    }

    @Override
    public Categorie updateCategorie(Long id, Categorie updatedCategorie) {
        Categorie existingCategorie = categorieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catégorie introuvable !"));

        existingCategorie.setNomCategorie(updatedCategorie.getNomCategorie());
        return categorieRepository.save(existingCategorie);
    }

    @Override
    public void deleteCategorie(Long id) {
        if (!categorieRepository.existsById(id)) {
            throw new RuntimeException("Catégorie introuvable !");
        }
        categorieRepository.deleteById(id);
    }
}
