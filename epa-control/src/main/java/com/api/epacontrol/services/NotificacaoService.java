package com.api.epacontrol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.epacontrol.models.Notificacao;
import com.api.epacontrol.repositories.NotificacaoRepository;
import java.util.UUID;

@Service
public class NotificacaoService {

    @Autowired
    NotificacaoRepository notificacaoRepository;

    public Notificacao save(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public boolean existsById(UUID id) {
        return notificacaoRepository.existsById(id);
    }

    
}
