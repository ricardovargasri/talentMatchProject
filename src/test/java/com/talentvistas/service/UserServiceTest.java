package com.talentvistas.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.talentvistas.repository.UserRepository;
import com.talentvistas.model.Usuario;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository);
    }

    @Test
    void whenFindByEmail_thenReturnUser() {
        // Arrange
        String email = "test@example.com";
        Usuario expectedUser = new Usuario("Test User", email, "password123");

        when(userRepository.findByEmail(email)).thenReturn(java.util.Optional.of(expectedUser));

        // Act
        Usuario foundUser = userService.findByEmail(email).orElseThrow();

        // Assert
        assertEquals(email, foundUser.getEmail());
        assertEquals("Test User", foundUser.getNombre());
        verify(userRepository).findByEmail(email);
    }

    @Test
    void whenFindByEmailNotFound_thenReturnEmpty() {
        // Arrange
        String email = "nonexistent@example.com";
        when(userRepository.findByEmail(email)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        assertTrue(userService.findByEmail(email).isEmpty());
        verify(userRepository).findByEmail(email);
    }

    @Test
    void whenSaveUser_thenReturnSavedUser() {
        // Arrange
        Usuario userToSave = new Usuario("New User", "new@example.com", "password123");
        when(userRepository.save(any(Usuario.class))).thenReturn(userToSave);

        // Act
        Usuario savedUser = userService.save(userToSave);

        // Assert
        assertNotNull(savedUser);
        assertEquals(userToSave.getEmail(), savedUser.getEmail());
        assertEquals(userToSave.getNombre(), savedUser.getNombre());
        verify(userRepository).save(userToSave);
    }
} 