package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    // Busca todos os pacientes; a ordenacao por prioridade e feita em Java,
    // porque o enum e salvo como STRING (alfabetico nao reflete a prioridade real)
    List<Paciente> findAll();
}