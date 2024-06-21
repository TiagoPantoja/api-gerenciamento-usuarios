package com.example.apiteste;

import com.example.apiteste.controller.UsuarioController;
import com.example.apiteste.model.Usuario;
import com.example.apiteste.service.UsuarioService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    private MockMvc mockMvc;

    @Test
    public void testCreateUser() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setName("Test User");
        usuario.setEmail("test@example.com");

        when(usuarioService.createUser(any(Usuario.class))).thenReturn(usuario);

        mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();

        mockMvc.perform(post("/api/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Test User\", \"email\": \"test@example.com\"}"))
                        .andExpect(status().isCreated())
                        .andExpect(jsonPath("$.name").value("Test User"))
                        .andExpect(jsonPath("$.email").value("test@example.com"));
    }

    @Test
    public void testGetAllUssers() throws Exception {
        Usuario usuario1 = new Usuario();
        usuario1.setName("Usuario 1");
        Usuario usuario2 = new Usuario();
        usuario2.setName("Usuario 2");

        List<Usuario> usuarios = Arrays.asList(usuario1, usuario2);

        when(usuarioService.getAllUsers()).thenReturn(usuarios);

        mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();

        mockMvc.perform(get("/api/usuarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Usuario 1"))
                .andExpect(jsonPath("$[1].name").value("Usuario 2"));
    }

    @Test
    public void testGetUserById() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setName("Test User");

        when(usuarioService.getUserById(1L)).thenReturn(usuario);

        mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();

        mockMvc.perform(get("/api/usuarios/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test User"));
    }

    @Test
    public void testUpdateUser() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setName("Test User");
        usuario.setEmail("updated@example.com");

        when(usuarioService.updateUser(eq(1L), any(Usuario.class))).thenReturn(usuario);

        mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();

        mockMvc.perform(put("/api/usuarios/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Test User\", \"email\":\"updated@example.com\"}"))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.name").value("Test User"));
    }

    @Test
    public void testDeleteUser() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();

        mockMvc.perform(delete("/api/usuarios/1"))
                .andExpect(status().isNoContent());

        verify(usuarioService, times(1)).deleteUser(1L);
    }
}
