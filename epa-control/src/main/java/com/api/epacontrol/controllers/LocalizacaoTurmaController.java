package com.api.epacontrol.controllers;

import com.api.epacontrol.dtos.LocalizacaoTurmaDto;
import com.api.epacontrol.models.LocalizacaoTurmaModel;
import com.api.epacontrol.services.LocalizacaoTurmaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/localizacaoTurma")
public class LocalizacaoTurmaController {

  @Autowired
  LocalizacaoTurmaService localizacaoTurmaService;

  @PostMapping
  public ResponseEntity<Object> saveLocalizacaoTurma(
    @RequestBody @Valid LocalizacaoTurmaDto localizacaoTurmaDto
  ) {
    if (localizacaoTurmaService.existsById(localizacaoTurmaDto.getId())) {
      return ResponseEntity
        .status(HttpStatus.CONFLICT)
        .body("Localização da turma já existe!");
    }

    var localizacaoTurma = new LocalizacaoTurmaModel();
    BeanUtils.copyProperties(localizacaoTurmaDto, localizacaoTurma);
    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body(localizacaoTurmaService.save(localizacaoTurma));
  }
}
