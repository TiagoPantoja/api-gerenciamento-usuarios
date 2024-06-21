package com.example.apiteste;

import com.example.apiteste.exception.ResourceNotFoundException;
import com.example.apiteste.model.Usuario;
import com.example.apiteste.repository.UsuarioRepository;
import com.example.apiteste.service.UsuarioService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    public void testCreateUser() {
        Usuario usuario = new Usuario();
        usuario.setName("Test User");
        usuario.setEmail("test@example.com");

        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario createdUser = usuarioService.createUser(usuario);

        assertNotNull(createdUser);
        assertEquals("Test User", createdUser.getName());
        assertEquals("test@example.com", createdUser.getEmail());
    }

    @Test
    public void testGetAllUsers() {
        Usuario usuario1 = new Usuario();
        usuario1.setName("Test User 1");
        Usuario usuario2 = new Usuario();
        usuario2.setName("Test User 2");

        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(usuario1, usuario2));

        List<Usuario> users = usuarioService.getAllUsers();

        assertEquals(2, users.size());
    }

    @Test
    public void testGetUserById() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setName("Test User");

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        Usuario user = usuarioService.getUserById(1L);

        assertNotNull(user);
        assertEquals("Test User", user.getName());
    }

    @Test
    public void testGetUserByIdNotFound() {
        when(usuarioRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            usuarioService.getUserById(1L);
        });
    }

    @Test
    public void testUpdateUser() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setName("Test User");
        usuario.setEmail("existing@example.com");

        Usuario updatedDetails = new Usuario();
        updatedDetails.setName("Updated User");
        updatedDetails.setEmail("updated@example.com");

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(updatedDetails);

        Usuario updatedUser = usuarioService.updateUser(1L, updatedDetails);

        assertNotNull(updatedUser);
        assertEquals("Updated User", updatedUser.getName());
        assertEquals("updated@example.com", updatedUser.getEmail());
    }

    @Test
    public void testDeleteUser() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setName("Test User");

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        doNothing().when(usuarioRepository).delete(usuario);

        usuarioService.deleteUser(1L);

        verify(usuarioRepository, times(1)).delete(usuario);
    }
}
