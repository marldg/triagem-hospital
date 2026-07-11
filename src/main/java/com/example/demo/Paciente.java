package com.example.demo;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_pacientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente implements Comparable<Paciente> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Gravidade gravidade;

    private LocalDateTime dataChegada;

    @Override
    public int compareTo(Paciente outro) {
        int comp = Integer.compare(this.gravidade.getPrioridade(), outro.gravidade.getPrioridade());
        if (comp != 0) {
            return comp;
        }
        return this.dataChegada.compareTo(outro.dataChegada);
    }

    @Override
    public String toString() {
        return String.format("[%s] - %s (Chegada: %s)",
                gravidade, nome, dataChegada.toLocalTime().toString().substring(0, 8));
    }
}