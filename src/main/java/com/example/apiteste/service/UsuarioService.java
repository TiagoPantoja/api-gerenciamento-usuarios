package com.example.apiteste.service;

import com.example.apiteste.exception.ResourceNotFoundException;
import com.example.apiteste.model.Usuario;
import com.example.apiteste.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario createUser(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    public Usuario getUserById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o id: " + id));
    }

    public Usuario updateUser(Long id, Usuario usuarioDetalhes) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o id: " + id));
        usuario.setName(usuarioDetalhes.getName());
        usuario.setEmail(usuarioDetalhes.getEmail());
        usuario.setDepartamento(usuarioDetalhes.getDepartamento());
        return usuarioRepository.save(usuario);
    }

    public void deleteUser(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o id: " + id));
        usuarioRepository.deleteById(id);
    }
}
