package com.talentvistas.service;

import com.talentvistas.dto.UserRegistrationDto;
import com.talentvistas.model.Usuario;
import com.talentvistas.repository.UserRepository;
import com.talentvistas.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public String register(UserRegistrationDto registration) {
        if (userRepository.existsByEmail(registration.getEmail())) {
            throw new RuntimeException("Email ya registrado");
        }

        Usuario usuario = new Usuario(
            registration.getNombre(),
            registration.getEmail(),
            passwordEncoder.encode(registration.getPassword())
        );

        userRepository.save(usuario);
        return jwtService.generateToken(usuario);
    }

    public String authenticate(String email, String password) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(email, password)
        );

        Usuario usuario = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return jwtService.generateToken(usuario);
    }
} 