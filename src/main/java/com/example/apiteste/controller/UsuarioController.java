package com.example.apiteste.controller;

import com.example.apiteste.model.Usuario;
import com.example.apiteste.service.UsuarioService;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @ApiOperation(value = "Cria um novo usuário")
    @PostMapping
    public Usuario createUser(@RequestBody Usuario usuario) {
        return usuarioService.createUser(usuario);
    }

    @ApiOperation(value = "Retorna todos os usuários")
    @GetMapping
    public List<Usuario> getAllUsers() {
        return usuarioService.getAllUsers();
    }

    @ApiOperation(value = "Retorna um usuário pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable Long id) {
        Usuario usuario = usuarioService.getUserById(id);
        return ResponseEntity.ok(usuario);
    }

    @ApiOperation(value = "Atualiza um usuário pelo ID")
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable Long id, @RequestBody Usuario usuarioDetalhes) {
        Usuario updatedUser = usuarioService.updateUser(id, usuarioDetalhes);
        return ResponseEntity.ok(updatedUser);
    }

    @ApiOperation(value = "Deleta um usuário pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        usuarioService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
