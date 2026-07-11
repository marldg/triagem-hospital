package com.example.demo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PacienteRequestDTO {

    @NotBlank(message = "O nome do paciente e obrigatorio")
    private String nome;

    @NotNull(message = "A gravidade e obrigatoria")
    private Gravidade gravidade;

    public PacienteRequestDTO() {}

    public PacienteRequestDTO(String nome, Gravidade gravidade) {
        this.nome = nome;
        this.gravidade = gravidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Gravidade getGravidade() {
        return gravidade;
    }

    public void setGravidade(Gravidade gravidade) {
        this.gravidade = gravidade;
    }
}