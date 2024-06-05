package com.api.epacontrol.services;

import com.api.epacontrol.models.CriarTurma;
import com.api.epacontrol.repositories.CriarTurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CriarTurmaService {

    @Autowired
    private CriarTurmaRepository criarTurmaRepository;

    public CriarTurma criarTurma(CriarTurma turma) {
        return criarTurmaRepository.save(turma);
    }

    public List<CriarTurma> listarTurmas() {
        return criarTurmaRepository.findAll();
    }

    public Optional<CriarTurma> obterTurma(UUID id) {
        return criarTurmaRepository.findById(id);
    }

    public void deletarTurma(UUID id) {
        criarTurmaRepository.deleteById(id);
    }
}
