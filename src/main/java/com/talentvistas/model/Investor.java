package com.talentvistas.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "investors")
public class Investor extends User {
    
    private String investmentPreferences;
    private Double availableCapital;
    
    @ManyToMany
    @JoinTable(
        name = "investor_interests",
        joinColumns = @JoinColumn(name = "investor_id"),
        inverseJoinColumns = @JoinColumn(name = "idea_id")
    )
    private Set<Idea> interestedIdeas = new HashSet<>();
    
    public Investor(String name, String email, String password) {
        super();
        setName(name);
        setEmail(email);
        setPassword(password);
        setUserType("INVESTOR");
    }
} 