package com.api.epacontrol.services;

import com.api.epacontrol.models.LocalizacaoTurmaModel;
import com.api.epacontrol.repositories.LocalizacaoTurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalizacaoTurmaService {

  @Autowired
  LocalizacaoTurmaRepository localizacaoTurmaRepository;

  public LocalizacaoTurmaModel save(LocalizacaoTurmaModel localizacaoTurma) {
    return localizacaoTurmaRepository.save(localizacaoTurma);
  }

  public boolean existsById(Long id) {
    return localizacaoTurmaRepository.existsById(id);
  }
}
