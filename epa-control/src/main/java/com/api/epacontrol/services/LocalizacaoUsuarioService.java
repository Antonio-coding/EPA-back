package com.api.epacontrol.services;

import com.api.epacontrol.models.LocalizacaoUsuarioModel;
import com.api.epacontrol.repositories.LocalizacaoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalizacaoUsuarioService {

  @Autowired
  LocalizacaoUsuarioRepository localizacaoUsuarioRepository;

  public LocalizacaoUsuarioModel save(
    LocalizacaoUsuarioModel localizacaoUsuario
  ) {
    return localizacaoUsuarioRepository.save(localizacaoUsuario);
  }

  public boolean existsById(Long id) {
    return localizacaoUsuarioRepository.existsById(id);
  }
}
