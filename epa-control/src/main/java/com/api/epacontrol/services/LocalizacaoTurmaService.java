package com.api.epacontrol.services;

import com.api.epacontrol.dtos.LocalizacaoTurmaDto;
import com.api.epacontrol.models.LocalizacaoTurmaModel;
import com.api.epacontrol.repositories.LocalizacaoTurmaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalizacaoTurmaService {

  @Autowired
  LocalizacaoTurmaRepository localizacaoTurmaRepository;

  public LocalizacaoTurmaModel save(LocalizacaoTurmaModel localizacaoTurma) {
    return localizacaoTurmaRepository.save(localizacaoTurma);
  }

  public boolean existsById(UUID id) {
    return localizacaoTurmaRepository.existsById(id);
  }

  public Optional<LocalizacaoTurmaModel> findById(UUID id) {
    return localizacaoTurmaRepository.findById(id);
  }

  public void deleteById(UUID id) {
    localizacaoTurmaRepository.deleteById(id);
  }

  public List<LocalizacaoTurmaModel> findAll() {
    return localizacaoTurmaRepository.findAll();
  }

  public boolean locationExists(LocalizacaoTurmaDto localizacaoTurmaDto) {
    List<LocalizacaoTurmaModel> turmas = localizacaoTurmaRepository.findByEnderecoAndCidade(
      localizacaoTurmaDto.getEndereco(),
      localizacaoTurmaDto.getCidade()
    );
    return !turmas.isEmpty();
  }
}
