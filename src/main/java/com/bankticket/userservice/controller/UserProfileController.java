package com.bankticket.userservice.controller;


import com.bankticket.userservice.entity.UserProfile;
import com.bankticket.userservice.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    // Save user profile
    @PostMapping("/save")
    public ResponseEntity<UserProfile> saveUser(@RequestBody UserProfile userProfile) {
        UserProfile saved = userProfileService.saveUserProfile(userProfile);
        return ResponseEntity.ok(saved);
    }

    // Get all user profiles
    @GetMapping("/all")
    public ResponseEntity<List<UserProfile>> getAllUsers() {
        return ResponseEntity.ok(userProfileService.getAllUsers());
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userProfileService.getUserById(id));
    }

    // Delete user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userProfileService.deleteUserById(id);
        return ResponseEntity.ok("User deleted successfully with ID: " + id);
    }
}
