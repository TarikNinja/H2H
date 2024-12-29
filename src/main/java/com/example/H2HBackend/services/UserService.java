package com.example.H2HBackend.services;

import com.example.H2HBackend.entities.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.management.relation.Role;
import java.util.List;
@Service
public interface UserService {
    User registerUser(User user);
    User registerUserWithAttachment(User user, MultipartFile file);
    User getUserById(Long idUser);
    List<User> getAllUsers();
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
    User updateUserProfileWithAttachment(Long idUser, User updatedUser, MultipartFile file);
}
