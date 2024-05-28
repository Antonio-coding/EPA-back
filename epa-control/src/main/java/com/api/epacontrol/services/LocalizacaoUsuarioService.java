package com.api.epacontrol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.epacontrol.models.LocalizacaoUsuario;
import com.api.epacontrol.repositories.LocalizacaoUsuarioRepository;

@Service
public class LocalizacaoUsuarioService {

    @Autowired
    LocalizacaoUsuarioRepository localizacaoUsuarioRepository;

    public LocalizacaoUsuario save(LocalizacaoUsuario localizacaoUsuario) {
        return localizacaoUsuarioRepository.save(localizacaoUsuario);
    }

    public boolean existsById(Long id) {
        return localizacaoUsuarioRepository.existsById(id);
    }

    
}
