package com.example.H2HBackend.controller;

import com.example.H2HBackend.entities.Annonce;
import com.example.H2HBackend.services.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/annonce")
public class AnnonceController {
    @Autowired
    private AnnonceService annonceService;

    @PostMapping("/add")
    public void addAnnonce(@RequestBody Annonce annonce) {
        annonceService.addAnnonce(annonce);
    }
    @PutMapping("/update/{idAnnonce}")
    public Annonce updateAnnonce(@PathVariable Long idAnnonce, @RequestBody Annonce updatedAnnonce) {
        return annonceService.updateAnnonce(idAnnonce, updatedAnnonce);
    }
    @DeleteMapping("/delete/{idAnnonce}")
    public void deleteAnnonce(@PathVariable Long idAnnonce) {
        annonceService.deleteAnnonce(idAnnonce);
    }
    @GetMapping("/getAllAnnonces")
    public List<Annonce> getAllAnnonces() {
        return annonceService.getAllAnnonces();
    }
    @GetMapping("/getAnnonceById/{idAnnonce}")
    public Annonce getAnnonceById(@PathVariable Long idAnnonce) {
        return annonceService.getAnnonceById(idAnnonce);
    }
    @GetMapping("/getAnnoncesByUser/{idUser}")
    public List<Annonce> getAnnoncesByUser(@PathVariable Long idUser) {
        return annonceService.getAnnoncesByUser(idUser);
    }
    @GetMapping("/searchAnnonces/{keyword}")
    public List<Annonce> searchAnnonces(@PathVariable String keyword) {
        return annonceService.searchAnnonces(keyword);
    }


}
