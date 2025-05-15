package com.talentvistas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.talentvistas.model.Usuario;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
} 