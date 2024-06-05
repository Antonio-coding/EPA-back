package com.api.epacontrol.repositories;

import com.api.epacontrol.models.LocalizacaoUsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizacaoUsuarioRepository
  extends JpaRepository<LocalizacaoUsuarioModel, Long> {}
