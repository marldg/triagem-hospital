package com.example.demo;

public enum Gravidade {
    VERMELHO(1, "GRAVISSIMO"),
    LARANJA(2, "GRAVE"),
    AMARELO(3, "Urgente"),
    VERDE(4, "Moderado"),
    AZUL(5, "Leve");

    private final int prioridade;
    private final String descricao;

    Gravidade(int prioridade, String descricao) {
        this.prioridade = prioridade;
        this.descricao = descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getDescricao() {
        return descricao;
    }
}