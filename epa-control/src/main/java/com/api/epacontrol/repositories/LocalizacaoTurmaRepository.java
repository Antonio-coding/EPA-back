package com.api.epacontrol.repositories;

import com.api.epacontrol.models.LocalizacaoTurmaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizacaoTurmaRepository
  extends JpaRepository<LocalizacaoTurmaModel, Long> {}
