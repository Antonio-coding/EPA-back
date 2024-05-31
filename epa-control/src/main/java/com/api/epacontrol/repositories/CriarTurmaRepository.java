package com.api.epacontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.epacontrol.models.CriarTurma;

import java.util.UUID;

@Repository
public interface CriarTurmaRepository extends JpaRepository<CriarTurma, UUID> {

}
