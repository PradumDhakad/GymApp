package com.prd.gymmanagementsystem.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
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
}
