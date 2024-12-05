package com.example.H2HBackend.entities;

import jakarta.persistence.*;
import lombok.*;

import javax.management.relation.Role;
import java.util.Date;
import java.util.List;
@Entity
@NoArgsConstructor @AllArgsConstructor
@Data
@ToString
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String nom;
    private String prenom;
    @Column(unique = true)
    private String email;
    private String password;
    private String username;
    private String numTel;
    @Column(unique = true,updatable = false)
    private String cin;
    private Role role;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Attachment avatar;
    private Date dateInscription;
    private int nbDons;
    private boolean active;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Annonce> annonces;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reclamation> reclamations;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Notification> notifications;

}
