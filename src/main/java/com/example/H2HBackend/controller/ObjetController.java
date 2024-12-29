package com.example.H2HBackend.controller;

import com.example.H2HBackend.entities.Objet;
import com.example.H2HBackend.enums.EtatObjet;
import com.example.H2HBackend.services.ObjetService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/objet")
public class ObjetController {
    private ObjetService objetService;

    @PostMapping("/add")
    public Objet createObjet(@RequestPart("objet") Objet objet,
                             @RequestPart(value = "image1", required = false) MultipartFile file1,
                             @RequestPart(value = "image2", required = false) MultipartFile file2,
                             @RequestPart(value = "image3", required = false) MultipartFile file3,
                             @RequestPart(value = "image4", required = false) MultipartFile file4,
                             @RequestPart(value = "image5", required = false) MultipartFile file5,
                             @RequestPart(value = "image6", required = false) MultipartFile file6) {
        return objetService.createObjet(objet, file1, file2, file3, file4, file5,file6);
    }

    @GetMapping("/getObjetById/{idObjet}")
    public Optional<Objet> getObjetById(@PathVariable Long idObjet) {
        return objetService.getObjetById(idObjet);
    }
    @GetMapping("/getAllObjets")
    public List<Objet> getAllObjets() {
        return objetService.getAllObjets();
    }
    @PutMapping("/update/{idObjet}")
    public Objet updateObjet(@PathVariable Long idObjet, @RequestBody Objet updatedObjet) {
        return objetService.updateObjet(idObjet, updatedObjet);
    }
    @DeleteMapping("/delete/{idObjet}")
    public void deleteObjet(@PathVariable Long idObjet) {
        objetService.deleteObjet(idObjet);
    }
    @GetMapping("/findByEtatObjet/{etatObjet}")
    public List<Objet> findByEtatObjet(@PathVariable EtatObjet etatObjet) {
        return objetService.findByEtatObjet(etatObjet);
    }
    @GetMapping("/findAvailableObjets")
    public List<Objet> findAvailableObjets() {
        return objetService.findAvailableObjets();
    }
    @GetMapping("/findByCategorie/{idCategorie}")
    public List<Objet> findByCategorie(@PathVariable Long idCategorie) {
        return objetService.findByCategorie(idCategorie);
    }
    @PutMapping("/reserveObjet/{idObjet}")
    public Objet reserveObjet(@PathVariable Long idObjet) {
        return objetService.reserveObjet(idObjet);
    }
    @PutMapping("/cancelReservation/{idObjet}")
    public Objet cancelReservation(@PathVariable Long idObjet) {
        return objetService.cancelReservation(idObjet);
    }
}
