package com.example.H2HBackend.services;

import com.example.H2HBackend.entities.Annonce;
import com.example.H2HBackend.entities.Notification;
import com.example.H2HBackend.entities.Reclamation;
import com.example.H2HBackend.entities.User;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;
@Service
public interface UserService {
    User registerUser(User user);
    boolean authenticate(String email, String password);
    User updateUserProfile(Long idUser, User updatedUser);
    boolean updatePassword(Long idUser, String oldPassword, String newPassword);
    List<Annonce> getUserAnnonces(Long idUser);
    List<Notification> getUnreadNotifications(Long idUser);
    void markNotificationAsRead(Long idNotification);
    int countUserDons(Long idUser);
    int countUserAnnonces(Long idUser);
    void deactivateUser(Long idUser);
    void deleteUser(Long idUser);
    void changeUserRole(Long idUser, Role newRole);
    List<Reclamation> getUserReclamations(Long idUser);
}
