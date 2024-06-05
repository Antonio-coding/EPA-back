package com.api.epacontrol.services;

import com.api.epacontrol.models.CriarTurmaModel;
import com.api.epacontrol.repositories.CriarTurmaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarTurmaService {

  @Autowired
  private CriarTurmaRepository criarTurmaRepository;

  public CriarTurmaModel save(CriarTurmaModel criarTurma) {
    return criarTurmaRepository.save(criarTurma);
  }

  public List<CriarTurmaModel> listarTurmas() {
    return criarTurmaRepository.findAll();
  }

  public Optional<CriarTurmaModel> obterTurma(UUID id) {
    return criarTurmaRepository.findById(id);
  }

  public void deletarTurma(UUID id) {
    criarTurmaRepository.deleteById(id);
  }
}
