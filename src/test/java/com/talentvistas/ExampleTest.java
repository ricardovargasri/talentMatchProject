package com.talentvistas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {

    @Test
    @DisplayName("Ejemplo de test simple")
    void simpleTest() {
        assertTrue(true, "Este test siempre pasa");
        assertEquals(4, 2 + 2, "La suma básica debería funcionar");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hola", "Mundo", "Test"})
    @DisplayName("Test parametrizado con diferentes strings")
    void parameterizedTest(String input) {
        assertNotNull(input);
        assertTrue(input.length() > 0);
    }

    @Test
    @DisplayName("Test que verifica una excepción")
    void exceptionTest() {
        Exception exception = assertThrows(
            IllegalArgumentException.class,
            () -> {
                throw new IllegalArgumentException("mensaje de error");
            }
        );

        assertEquals("mensaje de error", exception.getMessage());
    }
} 