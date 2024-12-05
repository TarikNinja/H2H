package com.example.H2HBackend.services.Impl;

import com.example.H2HBackend.entities.Annonce;
import com.example.H2HBackend.entities.Notification;
import com.example.H2HBackend.entities.Reclamation;
import com.example.H2HBackend.entities.User;
import com.example.H2HBackend.repositories.NotificationRepository;
import com.example.H2HBackend.repositories.UserRepository;
import com.example.H2HBackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private NotificationRepository notificationRepository;

    @Override
    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public boolean authenticate(String email, String password) {
        return userRepository.findByEmail(email)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }

    @Override
    public User updateUserProfile(Long idUser, User updatedUser) {
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.setNom(updatedUser.getNom());
        user.setPrenom(updatedUser.getPrenom());
        user.setEmail(updatedUser.getEmail());
        user.setNumTel(updatedUser.getNumTel());
        user.setUsername(updatedUser.getUsername());
        return userRepository.save(user);
    }

    @Override
    public boolean updatePassword(Long idUser, String oldPassword, String newPassword) {
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (!user.getPassword().equals(oldPassword)) {
            return false;
        }
        user.setPassword(newPassword);
        userRepository.save(user);
        return true;
    }

    @Override
    public List<Annonce> getUserAnnonces(Long idUser) {
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return user.getAnnonces();
    }

    @Override
    public List<Notification> getUnreadNotifications(Long idUser) {
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return user.getNotifications().stream()
                .filter(notification -> !notification.isEstLu())
                .toList();
    }

    @Override
    public void markNotificationAsRead(Long idNotification) {
        Notification notification = notificationRepository.findById(idNotification)
                .orElseThrow(() -> new IllegalArgumentException("Notification not found"));
        notification.setEstLu(true);
        notificationRepository.save(notification);
    }

    @Override
    public int countUserDons(Long idUser) {
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return user.getNbDons();
    }

    @Override
    public int countUserAnnonces(Long idUser) {
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return user.getAnnonces().size();
    }

    @Override
    public void deactivateUser(Long idUser) {
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setActive(false);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long idUser) {
        if (!userRepository.existsById(idUser)) {
            throw new IllegalArgumentException("User not found");
        }
        userRepository.deleteById(idUser);
    }

    @Override
    public void changeUserRole(Long idUser, Role newRole) {
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setRole(newRole);
        userRepository.save(user);
    }

    @Override
    public List<Reclamation> getUserReclamations(Long idUser) {
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return user.getReclamations();
    }
}
