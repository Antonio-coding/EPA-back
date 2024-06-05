package com.api.epacontrol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.epacontrol.models.Administrador;
import com.api.epacontrol.repositories.AdministradorRepository;

import java.util.Optional;

@Service
public class AdministradorService {

    @Autowired
    AdministradorRepository administradorRepository;

    public Administrador save(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    public Optional<Administrador> findById(String id) {
        return administradorRepository.findById(id);
    }

    public boolean existsById(String id) {
        return administradorRepository.existsById(id);
    }

    public void delete(Administrador administrador) {
        administradorRepository.delete(administrador);
    }

    // Other methods as needed
}