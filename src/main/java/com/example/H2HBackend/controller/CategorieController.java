package com.example.H2HBackend.controller;


import com.example.H2HBackend.entities.Categorie;
import com.example.H2HBackend.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorie")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    @PostMapping("/save")
    public Categorie addCategorie(@RequestBody Categorie categorie){
        return categorieService.addCategorie(categorie);
    }
    @GetMapping("/getAllCategories")
    public List<Categorie> getAllCategories()
    {
        return categorieService.getAllCategories();
    }
    @GetMapping("/getCategorieById/{id}")
    public Categorie getCategorieById( @PathVariable Long id)
    {
        return categorieService.getCategorieById(id);
    }
    @PutMapping("/update/{id}")
    public Categorie updateCategorie(Long id, Categorie updatedCategorie) {
        return categorieService.updateCategorie(id, updatedCategorie);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCategorie(@PathVariable Long id) {
        categorieService.deleteCategorie(id);
    }
}
