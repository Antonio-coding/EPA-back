package com.api.epacontrol.controllers;

import com.api.epacontrol.dtos.CriarTurmaDto;
import com.api.epacontrol.dtos.LocalizacaoTurmaDto;
import com.api.epacontrol.models.CriarTurmaModel;
import com.api.epacontrol.models.LocalizacaoTurmaModel;
import com.api.epacontrol.services.CriarTurmaService;
import com.api.epacontrol.services.LocalizacaoTurmaService;
import jakarta.validation.Valid;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/criarTurma")
public class CriarTurmaController {

  @Autowired
  CriarTurmaService criarTurmaService;

  @Autowired
  LocalizacaoTurmaService localizacaoTurmaService;

  @PostMapping
  public ResponseEntity<Object> saveCriarTurma(
    @RequestBody @Valid CriarTurmaDto criarTurmaDto
  ) {
    if (criarTurmaDto.getLocalizacao() == null) {
      return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body("Localização da turma não fornecida!");
    }

    LocalizacaoTurmaDto localizacaoTurmaDto = criarTurmaDto.getLocalizacao();
    LocalizacaoTurmaModel localizacaoTurma = new LocalizacaoTurmaModel();
    BeanUtils.copyProperties(localizacaoTurmaDto, localizacaoTurma);
    localizacaoTurmaService.save(localizacaoTurma);

    CriarTurmaModel criarTurma = new CriarTurmaModel();
    BeanUtils.copyProperties(criarTurmaDto, criarTurma);
    criarTurma.setLocalizacao(localizacaoTurma);
    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body(criarTurmaService.save(criarTurma));
  }

  @GetMapping
  public ResponseEntity<Page<CriarTurmaModel>> getAllTurmas(
    @PageableDefault(
      page = 0,
      size = 10,
      sort = "id",
      direction = Sort.Direction.ASC
    ) Pageable pageable
  ) {
    return ResponseEntity
      .status(HttpStatus.OK)
      .body(criarTurmaService.findAll(pageable));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getTurmaById(
    @PathVariable(value = "id") UUID id
  ) {
    Optional<CriarTurmaModel> turmaOptional = criarTurmaService.findById(id);
    if (!turmaOptional.isPresent()) {
      return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body("Turma não encontrada");
    }
    return ResponseEntity.status(HttpStatus.OK).body(turmaOptional.get());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteTurma(
    @PathVariable(value = "id") UUID id
  ) {
    Optional<CriarTurmaModel> turmaOptional = criarTurmaService.findById(id);
    if (!turmaOptional.isPresent()) {
      return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body("Turma não encontrada");
    }
    criarTurmaService.delete(turmaOptional.get());
    return ResponseEntity
      .status(HttpStatus.OK)
      .body("Turma deletada com sucesso");
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> updateTurma(
    @PathVariable(value = "id") UUID id,
    @RequestBody @Valid CriarTurmaDto criarTurmaDto
  ) {
    Optional<CriarTurmaModel> turmaOptional = criarTurmaService.findById(id);
    if (!turmaOptional.isPresent()) {
      return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body("Turma não encontrada");
    }

    var criarTurma = turmaOptional.get();
    BeanUtils.copyProperties(criarTurmaDto, criarTurma, "id", "localizacao");
    if (criarTurmaDto.getLocalizacao() != null) {
      LocalizacaoTurmaDto localizacaoTurmaDto = criarTurmaDto.getLocalizacao();
      LocalizacaoTurmaModel localizacaoTurma = new LocalizacaoTurmaModel();
      BeanUtils.copyProperties(localizacaoTurmaDto, localizacaoTurma);
      localizacaoTurmaService.save(localizacaoTurma);
      criarTurma.setLocalizacao(localizacaoTurma);
    }

    return ResponseEntity
      .status(HttpStatus.OK)
      .body(criarTurmaService.save(criarTurma));
  }
}
