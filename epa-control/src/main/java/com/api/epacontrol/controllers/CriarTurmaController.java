package com.api.epacontrol.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/turmas")
public class CriarTurmaController {

    @Autowired
    private CriarTurmaRepository criarTurmaRepository;

    @GetMapping
    public List<CriarTurma> getAllTurmas() {
        return criarTurmaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriarTurma> getTurmaById(@PathVariable UUID id) {
        Optional<CriarTurma> turma = criarTurmaRepository.findById(id);
        return turma.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CriarTurma> createTurma(@RequestParam("nomeTurma") String nomeTurma,
                                                   @RequestParam("foto") MultipartFile foto,
                                                   @RequestParam("nomeDisciplina") String nomeDisciplina,
                                                   @RequestParam("nivel") String nivel,
                                                   @RequestParam("hora") String hora,
                                                   @RequestParam("data") String data,
                                                   @RequestParam("endereco") String endereco,
                                                   @RequestParam("cidade") String cidade,
                                                   @RequestParam("estado") String estado) throws IOException {
        CriarTurma turma = new CriarTurma();
        turma.setNomeTurma(nomeTurma);
        turma.setFoto(foto.getBytes());
        turma.setNomeDisciplina(nomeDisciplina);
        turma.setNivel(nivel);
        turma.setHora(LocalDateTime.parse(hora));
        turma.setData(LocalDateTime.parse(data));
        
        LocalizacaoTurma localizacao = new Localizacao();
        localizacao.setEndereco(endereco);
        localizacao.setCidade(cidade);
        localizacao.setEstado(estado);
        turma.setLocalizacao(localizacao);

        CriarTurma savedTurma = criarTurmaRepository.save(turma);
        return new ResponseEntity<>(savedTurma, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CriarTurma> updateTurma(@PathVariable UUID id,
                                                   @RequestParam("nomeTurma") String nomeTurma,
                                                   @RequestParam("foto") MultipartFile foto,
                                                   @RequestParam("nomeDisciplina") String nomeDisciplina,
                                                   @RequestParam("nivel") String nivel,
                                                   @RequestParam("hora") String hora,
                                                   @RequestParam("data") String data,
                                                   @RequestParam("endereco") String endereco,
                                                   @RequestParam("cidade") String cidade,
                                                   @RequestParam("estado") String estado) throws IOException {
        Optional<CriarTurma> turmaOptional = criarTurmasRepository.findById(id);
        if (turmaOptional.isPresent()) {
            CriarTurma turma = turmaOptional.get();
            turma.setNomeTurma(nomeTurma);
            turma.setFoto(foto.getBytes());
            turma.setNomeDisciplina(nomeDisciplina);
            turma.setNivel(nivel);
            turma.setHora(LocalDateTime.parse(hora));
            turma.setData(LocalDateTime.parse(data));
            
            LocalizacaoTurma localizacao = new Localizacao();
            localizacao.setEndereco(endereco);
            localizacao.setCidade(cidade);
            localizacao.setEstado(estado);
            turma.setLocalizacao(localizacao);

            CriarTurma updatedTurma = criarTurmaRepository.save(turma);
            return ResponseEntity.ok(updatedTurma);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurma(@PathVariable UUID id) {
        if (criarTurmaRepository.existsById(id)) {
            criarTurmaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
