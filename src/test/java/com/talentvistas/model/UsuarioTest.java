package com.talentvistas.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {
    
    private Usuario usuario;
    
    @BeforeEach
    void setUp() {
        // Este método se ejecuta antes de cada prueba
        usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setEmail("juan@example.com");
    }
    
    @Test
    @DisplayName("Verificar que el nombre del usuario se guarda correctamente")
    void testNombreUsuario() {
        // 1. Preparación (ya hecha en setUp)
        
        // 2. Ejecución
        String nombreGuardado = usuario.getNombre();
        
        // 3. Verificación
        assertEquals("Juan", nombreGuardado, "El nombre del usuario debe ser Juan");
    }
    
    @Test
    @DisplayName("Verificar que el email es válido")
    void testEmailValido() {
        // 1. Preparación
        String emailInvalido = "correo.invalido";
        
        // 2. Ejecución y 3. Verificación
        assertThrows(IllegalArgumentException.class, () -> {
            usuario.setEmail(emailInvalido);
        }, "Debería lanzar una excepción cuando el email es inválido");
    }
} 