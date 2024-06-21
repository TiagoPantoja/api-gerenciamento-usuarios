package com.example.apiteste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiteste.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
