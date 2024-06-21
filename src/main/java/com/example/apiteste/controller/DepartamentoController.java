package com.example.apiteste.controller;

import com.example.apiteste.model.Departamento;
import com.example.apiteste.service.DepartamentoService;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @ApiOperation(value = "Cria um novo departamento")
    @PostMapping
    public Departamento createDepartamento(@RequestBody Departamento departamento) {
        return departamentoService.createDepartamento(departamento);
    }

    @ApiOperation(value = "Retorna todos os departamentos")
    @GetMapping
    public List<Departamento> getAllDepartamentos() {
        return departamentoService.getAllDepartamentos();
    }

    @ApiOperation(value = "Retorna um departamento pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<Departamento> getDepartamentoById(@PathVariable Long id) {
        Departamento departamento = departamentoService.getDepartamentoById(id);
        return ResponseEntity.ok(departamento);
    }
}

