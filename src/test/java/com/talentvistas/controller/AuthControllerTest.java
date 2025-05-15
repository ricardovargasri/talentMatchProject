package com.talentvistas.controller;

import com.talentvistas.model.Usuario;
import com.talentvistas.service.AuthService;
import com.talentvistas.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthService authService;

    @MockBean
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Usuario testUser;
    private static final String TEST_EMAIL = "test@example.com";
    private static final String TEST_PASSWORD = "password123";

    @BeforeEach
    void setUp() {
        testUser = new Usuario();
        testUser.setEmail(TEST_EMAIL);
        testUser.setPassword(passwordEncoder.encode(TEST_PASSWORD));
        testUser.setNombre("Test User");

        when(userService.findByEmail(TEST_EMAIL)).thenReturn(Optional.of(testUser));
        when(authService.authenticate(TEST_EMAIL, TEST_PASSWORD)).thenReturn("jwt-token-example");
    }

    @Test
    void whenLoginWithValidCredentials_thenReturnsToken() throws Exception {
        String loginRequest = String.format(
            "{\"email\":\"%s\",\"password\":\"%s\"}", 
            TEST_EMAIL, 
            TEST_PASSWORD
        );

        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(loginRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists());
    }

    @Test
    void whenLoginWithInvalidCredentials_thenReturnsUnauthorized() throws Exception {
        String loginRequest = "{\"email\":\"invalid@example.com\",\"password\":\"wrongpass\"}";

        when(userService.findByEmail("invalid@example.com")).thenReturn(Optional.empty());

        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(loginRequest))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.error").value("Credenciales inválidas"));
    }
} 