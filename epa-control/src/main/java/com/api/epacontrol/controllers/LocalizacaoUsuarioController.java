package com.api.epacontrol.controllers;

import com.api.epacontrol.dtos.LocalizacaoUsuarioDto;
import com.api.epacontrol.models.LocalizacaoUsuarioModel;
import com.api.epacontrol.services.LocalizacaoUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/localizacao")
public class LocalizacaoUsuarioController {

  @Autowired
  LocalizacaoUsuarioService localizacaoUsuarioService;

  @PostMapping
  public ResponseEntity<Object> saveLocalizacaoUsuario(
    @RequestBody @Valid LocalizacaoUsuarioDto localizacaoUsuarioDto
  ) {
    if (localizacaoUsuarioService.existsById(localizacaoUsuarioDto.getId())) {
      return ResponseEntity
        .status(HttpStatus.CONFLICT)
        .body("Localização já existe!");
    }

    var localizacaoUsuario = new LocalizacaoUsuarioModel();
    BeanUtils.copyProperties(localizacaoUsuarioDto, localizacaoUsuario);
    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body(localizacaoUsuarioService.save(localizacaoUsuario));
  }
}
