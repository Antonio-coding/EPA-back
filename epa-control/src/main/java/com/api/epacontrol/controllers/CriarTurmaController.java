package com.api.epacontrol.controllers;

import com.api.epacontrol.dtos.CriarTurmaDto;
import com.api.epacontrol.dtos.LocalizacaoTurmaDto;
import com.api.epacontrol.models.CriarTurmaModel;
import com.api.epacontrol.models.LocalizacaoTurmaModel;
import com.api.epacontrol.services.CriarTurmaService;
import com.api.epacontrol.services.LocalizacaoTurmaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
  LocalizacaoTurmaService localizacaoTurmaService; // Injete o serviço LocalizacaoTurmaService

  @PostMapping
  public ResponseEntity<Object> saveCriarTurma(
    @RequestBody @Valid CriarTurmaDto criarTurmaDto
  ) {
    // Verifique se a LocalizacaoTurmaModel associada está presente no DTO
    if (criarTurmaDto.getLocalizacao() == null) {
      return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body("Localização da turma não fornecida!");
    }

    // Salvar a LocalizacaoTurmaModel primeiro
    LocalizacaoTurmaDto localizacaoTurmaDto = criarTurmaDto.getLocalizacao();
    LocalizacaoTurmaModel localizacaoTurma = new LocalizacaoTurmaModel();
    BeanUtils.copyProperties(localizacaoTurmaDto, localizacaoTurma);
    localizacaoTurmaService.save(localizacaoTurma);

    // Agora, salve a CriarTurmaModel com a LocalizacaoTurmaModel associada
    CriarTurmaModel criarTurma = new CriarTurmaModel();
    BeanUtils.copyProperties(criarTurmaDto, criarTurma);
    criarTurma.setLocalizacao(localizacaoTurma); // Associe a LocalizacaoTurmaModel
    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body(criarTurmaService.save(criarTurma));
  }
}
