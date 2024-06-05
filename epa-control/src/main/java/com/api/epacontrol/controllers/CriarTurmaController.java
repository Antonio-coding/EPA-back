package com.api.epacontrol.controllers;

import com.api.epacontrol.models.CriarTurma;
import com.api.epacontrol.services.CriarTurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/turmas")
public class CriarTurmaController {

    @Autowired
    private CriarTurmaService criarTurmaService;

    @PostMapping
    public CriarTurma criarTurma(@RequestBody CriarTurma turma) {
        return criarTurmaService.criarTurma(turma);
    }

    @GetMapping
    public List<CriarTurma> listarTurmas() {
        return criarTurmaService.listarTurmas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriarTurma> obterTurma(@PathVariable UUID id) {
        Optional<CriarTurma> turma = criarTurmaService.obterTurma(id);
        if (turma.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(turma.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTurma(@PathVariable UUID id) {
        criarTurmaService.deletarTurma(id);
        return ResponseEntity.noContent().build();
    }
}
