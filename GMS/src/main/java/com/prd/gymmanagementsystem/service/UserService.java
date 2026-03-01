package com.prd.gymmanagementsystem.service;

import com.prd.gymmanagementsystem.model.DietPlan;
import com.prd.gymmanagementsystem.model.User;
import com.prd.gymmanagementsystem.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    // Initialize the logger
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        logger.info("Attempting to register new user with username: {}", user.getUsername());
        User savedUser = userRepository.save(user);
        logger.info("User registered successfully with ID: {}", savedUser.getId());
        return savedUser;
    }

    public User loginUser(String username, String password) {
        logger.debug("Login attempt for username: {}", username);
        User user = userRepository.findByUsername(username).orElse(null);

        if (user != null && user.getPassword().equals(password)) {
            logger.info("User '{}' logged in successfully", username);
            return user;
        }

        logger.warn("Failed login attempt for username: {}", username);
        throw new RuntimeException("Invalid Credentials");
    }

    public User updateDietPlan(Long userId, DietPlan plan) {
        logger.info("Updating diet plan for user ID: {}", userId);

        User user = userRepository.findById(userId).orElseThrow(() -> {
            logger.error("Update failed: User with ID {} not found", userId);
            return new RuntimeException("User not found");
        });

        user.setDietPlan(plan);
        User updatedUser = userRepository.save(user);
        logger.info("Diet plan updated successfully for user: {}", user.getUsername());
        return updatedUser;
    }

    public List<User> getAllUsers() {
        logger.debug("Fetching all users from the database");
        return userRepository.findAll();
    }
}