package com.example.H2HBackend.entities;

import jakarta.persistence.*;
import lombok.*;

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
    private LocalDateTime dateNotification;
    private boolean estLu;
}
