package com.prd.gymmanagementsystem.model;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // e.g., "Gold", "Silver"
    private LocalDate startDate;
    private LocalDate endDate;
    private String status; // "ACTIVE", "EXPIRED"
}
