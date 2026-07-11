package com.example.demo;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalTriagemService {

    private final PacienteRepository pacienteRepository;

    public HospitalTriagemService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente darEntradaPaciente(String nome, Gravidade gravidade) {
        Paciente novoPaciente = new Paciente(null, nome, gravidade, LocalDateTime.now());
        Paciente salvo = pacienteRepository.save(novoPaciente);
        System.out.println("Novo paciente " + nome + " registrado, sua triagem e: " + gravidade);
        return salvo;
    }

    public List<Paciente> listarFilaOrdenada() {
        List<Paciente> fila = pacienteRepository.findAll();
        fila.sort(Paciente::compareTo);
        return fila;
    }

    public Optional<Paciente> chamarProximo() {
        List<Paciente> fila = pacienteRepository.findAll();

        Optional<Paciente> proximo = fila.stream().min(Paciente::compareTo);

        if (proximo.isEmpty()) {
            System.out.println("Nenhum paciente a espera");
        } else {
            Paciente p = proximo.get();
            System.out.println("Por favor " + p.getNome() + " comparecer ao atendimento");
            pacienteRepository.delete(p); // remove da fila apos chamar
        }

        return proximo;
    }
}