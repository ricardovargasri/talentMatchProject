package com.talentvistas.service;

import org.springframework.stereotype.Service;
import com.talentvistas.repository.UserRepository;
import com.talentvistas.model.Usuario;
import java.util.Optional;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<Usuario> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Usuario save(Usuario usuario) {
        return userRepository.save(usuario);
    }
} 