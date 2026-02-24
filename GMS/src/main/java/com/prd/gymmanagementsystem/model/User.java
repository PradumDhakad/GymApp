package com.prd.gymmanagementsystem.model;


import jakarta.persistence.*;

@Entity
@Table(name = "gym_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password; // In production, always encrypt this!
    private String email;
    private String role; // e.g., "MEMBER", "ADMIN"

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "membership_id")
    private Membership membership;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diet_plan_id")
    private DietPlan dietPlan;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public DietPlan getDietPlan() {
        return dietPlan;
    }

    public void setDietPlan(DietPlan dietPlan) {
        this.dietPlan = dietPlan;
    }
}
