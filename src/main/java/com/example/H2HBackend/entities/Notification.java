package com.example.H2HBackend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotification;
    @Column(columnDefinition = "LONGTEXT")
    private String message;
    @Temporal(TemporalType.DATE)
    private LocalDate dateNotification;
    private boolean estLu;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;
}
