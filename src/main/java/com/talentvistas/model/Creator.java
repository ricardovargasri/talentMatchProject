package com.talentvistas.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "creators")
public class Creator extends User {
    
    private String expertise;
    private String education;
    
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private List<Idea> ideas = new ArrayList<>();
    
    public Creator(String name, String email, String password) {
        super();
        setName(name);
        setEmail(email);
        setPassword(password);
        setUserType("CREATOR");
    }
} 