package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/triagem")
public class PacienteController {

    private final HospitalTriagemService hospitalTriagemService;

    public PacienteController(HospitalTriagemService hospitalTriagemService) {
        this.hospitalTriagemService = hospitalTriagemService;
    }

    @PostMapping("/entrada")
    public ResponseEntity<PacienteResponseDTO> darEntrada(@Valid @RequestBody PacienteRequestDTO dto) {
        Paciente paciente = hospitalTriagemService.darEntradaPaciente(dto.getNome(), dto.getGravidade());
        return ResponseEntity.ok(new PacienteResponseDTO(paciente));
    }

    @GetMapping("/fila")
    public ResponseEntity<List<PacienteResponseDTO>> listarFila() {
        List<PacienteResponseDTO> fila = hospitalTriagemService.listarFilaOrdenada()
                .stream()
                .map(PacienteResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(fila);
    }

    @PostMapping("/chamar-proximo")
    public ResponseEntity<?> chamarProximo() {
        Optional<Paciente> proximo = hospitalTriagemService.chamarProximo();

        if (proximo.isEmpty()) {
            return ResponseEntity.ok("Nenhum paciente na fila de espera.");
        }
        return ResponseEntity.ok(new PacienteResponseDTO(proximo.get()));
    }
}