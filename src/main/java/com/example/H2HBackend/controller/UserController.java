package com.example.H2HBackend.controller;

import com.example.H2HBackend.entities.Annonce;
import com.example.H2HBackend.entities.Notification;
import com.example.H2HBackend.entities.Reclamation;
import com.example.H2HBackend.entities.User;
import com.example.H2HBackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.management.relation.Role;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private  UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
    @PostMapping("/registerWithAttachment")
    public User registerUserWithAttachment(@RequestBody User user,@RequestPart(value = "image", required = false) MultipartFile file) {
        return userService.registerUserWithAttachment(user, file);
    }
    @GetMapping("/getUserById/{idUser}")
    public User getUserById(Long idUser) {
        return userService.getUserById(idUser);
    }
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @PostMapping("/authenticate")
    public boolean authenticate(@RequestParam String email, @RequestParam String password) {
        return userService.authenticate(email, password);
    }
    @PutMapping("/updateUserProfile/{idUser}")
    public User updateUserProfile(@PathVariable Long idUser, @RequestBody User updatedUser) {
        return userService.updateUserProfile(idUser, updatedUser);
    }
    @PutMapping("/updateUserProfileWithAttachment/{idUser}")
    public User updateUserProfileWithAttachment(@PathVariable Long idUser, @RequestBody User updatedUser, @RequestPart(value = "image", required = false) MultipartFile file) {
        return userService.updateUserProfileWithAttachment(idUser, updatedUser, file);
    }
    @PutMapping("/updatePassword/{idUser}")
    public boolean updatePassword(@PathVariable Long idUser, @RequestParam String oldPassword, @RequestParam String newPassword) {
        return userService.updatePassword(idUser, oldPassword, newPassword);
    }
    @GetMapping("/getUserAnnonces/{idUser}")
    public List<Annonce> getUserAnnonces(@PathVariable Long idUser) {
        return userService.getUserAnnonces(idUser);
    }
    @GetMapping("/getUnreadNotifications/{idUser}")
    public List<Notification> getUnreadNotifications(@PathVariable Long idUser) {
        return userService.getUnreadNotifications(idUser);
    }
    @PutMapping("/markNotificationAsRead/{idNotification}")
    public void markNotificationAsRead(@PathVariable Long idNotification) {
        userService.markNotificationAsRead(idNotification);
    }
    @GetMapping("/countUserDons/{idUser}")
    public int countUserDons(@PathVariable Long idUser) {
        return userService.countUserDons(idUser);
    }
    @GetMapping("/countUserAnnonces/{idUser}")
    public int countUserAnnonces(@PathVariable Long idUser) {
        return userService.countUserAnnonces(idUser);
    }
    @PutMapping("/deactivateUser/{idUser}")
    public void deactivateUser(@PathVariable Long idUser) {
        userService.deactivateUser(idUser);
    }
    @DeleteMapping("/deleteUser/{idUser}")
    public void deleteUser(@PathVariable Long idUser) {
        userService.deleteUser(idUser);
    }
    @PutMapping("/changeUserRole/{idUser}")
    public void changeUserRole(@PathVariable Long idUser, @RequestParam Role newRole) {
        userService.changeUserRole(idUser, newRole);
    }
    @GetMapping("/getUserReclamations/{idUser}")
    public List<Reclamation> getUserReclamations(@PathVariable Long idUser) {
        return userService.getUserReclamations(idUser);
    }


}
