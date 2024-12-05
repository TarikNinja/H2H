package com.example.H2HBackend.repositories;

import com.example.H2HBackend.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Long> {

}
