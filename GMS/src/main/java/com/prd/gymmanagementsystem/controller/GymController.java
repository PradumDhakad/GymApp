package com.prd.gymmanagementsystem.controller;

import com.prd.gymmanagementsystem.model.DietPlan;
import com.prd.gymmanagementsystem.model.User;
import com.prd.gymmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gym")
public class GymController {

    @Autowired
    private UserService userService;

    // 1. Registration Endpoint
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    // 2. Login Endpoint
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        try {
            userService.loginUser(username, password);
            return ResponseEntity.ok("Login Successful");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 3. Update Diet Plan
    @PostMapping("/{userId}/diet")
    public ResponseEntity<User> assignDiet(@PathVariable Long userId, @RequestBody DietPlan dietPlan) {
        return ResponseEntity.ok(userService.updateDietPlan(userId, dietPlan));
    }

    // 4. Get All Users (Admin feature)
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
