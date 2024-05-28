package com.api.epacontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.epacontrol.models.LocalizacaoTurma;

@Repository
public interface LocalizacaoTurmaRepository extends JpaRepository<LocalizacaoTurma, Long> {
}
