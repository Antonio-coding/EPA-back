package com.api.epacontrol.repositories;

import com.api.epacontrol.models.CriarTurmaModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriarTurmaRepository
  extends JpaRepository<CriarTurmaModel, UUID> {}
