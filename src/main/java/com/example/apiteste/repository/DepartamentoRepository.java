package com.example.apiteste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiteste.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
}
