package com.api.epacontrol.repositories;

import com.api.epacontrol.models.LocalizacaoTurmaModel;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizacaoTurmaRepository
  extends JpaRepository<LocalizacaoTurmaModel, UUID> {
  List<LocalizacaoTurmaModel> findByEnderecoAndCidade(
    String endereco,
    String cidade
  );
}
