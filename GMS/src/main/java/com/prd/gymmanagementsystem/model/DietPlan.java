package com.prd.gymmanagementsystem.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DietPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String breakfast;
    private String lunch;
    private String dinner;
    private int calorieTarget;
}
