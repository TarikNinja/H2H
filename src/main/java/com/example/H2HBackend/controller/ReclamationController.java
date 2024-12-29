package com.example.H2HBackend.controller;


import com.example.H2HBackend.entities.Reclamation;
import com.example.H2HBackend.enums.ObjetReclamation;
import com.example.H2HBackend.services.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reclamation")
public class ReclamationController {
    @Autowired
    private ReclamationService reclamationService;

    @PostMapping("/save")
    public Reclamation createReclamation(@RequestBody Reclamation reclamation)
    {
        return reclamationService.createReclamation(reclamation);
    }
    @GetMapping("/get/{idReclamation}")
    public Reclamation updateReclamation(@PathVariable Long idReclamation,@RequestBody Reclamation updatedReclamation) {
        return reclamationService.updateReclamation(idReclamation, updatedReclamation);
    }
    @DeleteMapping("/delete/{idReclamation}")
    public void deleteReclamation(@PathVariable Long idReclamation) {
        reclamationService.deleteReclamation(idReclamation);
    }
    @GetMapping("/getAll")
    public List<Reclamation> getAllReclamations()
    {
        return reclamationService.getAllReclamations();
    }
    @GetMapping("/getById/{idReclamation}")
    public Reclamation getReclamationById(@PathVariable Long idReclamation)
    {
        return reclamationService.getReclamationById(idReclamation);
    }
    @GetMapping("/getByUserId/{idUser}")
    public List<Reclamation> getReclamationsByUserId(@PathVariable Long idUser)
    {
        return reclamationService.getReclamationsByUserId(idUser);
    }
    @GetMapping("/getByObjet/{objetReclamation}")
    public List<Reclamation> getReclamationsByObjet(@PathVariable ObjetReclamation objetReclamation)
    {
        return reclamationService.getReclamationsByObjet(objetReclamation);
    }
    @GetMapping("/getByDate/{dateReclamation}")
    public List<Reclamation> getReclamationsByDate(@PathVariable LocalDate dateReclamation)
    {
        return reclamationService.getReclamationsByDate(dateReclamation);
    }
}
