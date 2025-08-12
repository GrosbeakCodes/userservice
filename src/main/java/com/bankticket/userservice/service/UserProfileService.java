package com.bankticket.userservice.service;



import com.bankticket.userservice.entity.UserProfile;
import com.bankticket.userservice.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    // Save or update user profile
    public UserProfile saveUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    // Get all users
    public List<UserProfile> getAllUsers() {
        return userProfileRepository.findAll();
    }

    // Get user by ID
    public UserProfile getUserById(Long id) {
        return userProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    // Delete user by ID
    public void deleteUserById(Long id) {
        userProfileRepository.deleteById(id);
    }
}
