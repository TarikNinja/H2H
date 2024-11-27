package com.example.H2HBackend.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;

import javax.management.relation.Role;
import java.util.Date;

public class User {
    private Long idUser;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String username;
    private String numTel;
    private String cin;
    private Role role;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Attachment avatar;
    private Date dateInscription;
    private int nbDons;

}
