package com.api.epacontrol.controllers;

import com.api.epacontrol.models.CriarTurmaModel;
import com.api.epacontrol.services.CriarTurmaService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/turmas")
public class CriarTurmaController {

  @Autowired
  private CriarTurmaService criarTurmaService;

  @PostMapping
  public CriarTurmaModel criarTurma(@RequestBody CriarTurmaModel turma) {
    return criarTurmaService.criarTurma(turma);
  }

  @GetMapping
  public List<CriarTurmaModel> listarTurmas() {
    return criarTurmaService.listarTurmas();
  }

  @GetMapping("/{id}")
  public ResponseEntity<CriarTurmaModel> obterTurma(@PathVariable UUID id) {
    Optional<CriarTurmaModel> turma = criarTurmaService.obterTurma(id);
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
