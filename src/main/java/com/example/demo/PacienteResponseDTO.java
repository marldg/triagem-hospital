package com.example.demo;

import java.time.LocalDateTime;


public class PacienteResponseDTO {

    private Long id;
    private String nome;
    private Gravidade gravidade;
    private String descricaoGravidade;
    private LocalDateTime dataChegada;

    public PacienteResponseDTO(Paciente paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.gravidade = paciente.getGravidade();
        this.descricaoGravidade = paciente.getGravidade().getDescricao();
        this.dataChegada = paciente.getDataChegada();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Gravidade getGravidade() {
        return gravidade;
    }

    public String getDescricaoGravidade() {
        return descricaoGravidade;
    }

    public LocalDateTime getDataChegada() {
        return dataChegada;
    }
}