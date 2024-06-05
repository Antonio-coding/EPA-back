package com.api.epacontrol.services;

import com.api.epacontrol.models.NotificacaoModel;
import com.api.epacontrol.repositories.NotificacaoRepository;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {

  @Autowired
  NotificacaoRepository notificacaoRepository;

  public NotificacaoModel save(NotificacaoModel notificacao) {
    return notificacaoRepository.save(notificacao);
  }

  public boolean existsById(UUID id) {
    return notificacaoRepository.existsById(id);
  }
}
