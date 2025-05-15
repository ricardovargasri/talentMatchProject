package com.talentvistas.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ideas")
public class Idea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 2000)
    private String description;

    private String category;
    
    @Column(nullable = false)
    private Double requiredInvestment;
    
    private String status = "PENDING"; // PENDING, FUNDED, COMPLETED
    
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private Creator creator;
    
    @ManyToMany(mappedBy = "interestedIdeas")
    private Set<Investor> interestedInvestors = new HashSet<>();
    
    // Campos adicionales que pueden ser útiles
    private String businessPlan;
    private String marketAnalysis;
    private Double expectedReturn;
    private Integer estimatedTimeMonths;
} 