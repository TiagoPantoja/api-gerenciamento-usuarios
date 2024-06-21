package com.example.apiteste.service;

import com.example.apiteste.model.Departamento;
import com.example.apiteste.repository.DepartamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Departamento createDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public List<Departamento> getAllDepartamentos() {
        return departamentoRepository.findAll();
    }

    public Departamento getDepartamentoById(Long id) {
        return departamentoRepository.findById(id).orElseThrow();
    }
}
