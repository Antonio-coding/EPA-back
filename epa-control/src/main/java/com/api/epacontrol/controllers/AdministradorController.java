package com.api.epacontrol.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.epacontrol.dtos.AdministradorDto;
import com.api.epacontrol.models.Administrador;
import com.api.epacontrol.services.AdministradorService;

import jakarta.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    AdministradorService administradorService;

    @PostMapping
    public ResponseEntity<Object> saveAdministrador(@RequestBody @Valid AdministradorDto administradorDto) {
        if (administradorService.existsById(administradorDto.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Administrador já existe!");
        }

        var administrador = new Administrador();
        BeanUtils.copyProperties(administradorDto, administrador);
        return ResponseEntity.status(HttpStatus.CREATED).body(administradorService.save(administrador));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAdministradorById(@PathVariable(value = "id") String id) {
        Optional<Administrador> administradorOptional = administradorService.findById(id);
        if (!administradorOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Administrador não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(administradorOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAdministrador(@PathVariable(value = "id") String id) {
        Optional<Administrador> administradorOptional = administradorService.findById(id);
        if (!administradorOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Administrador não encontrado!");
        }
        administradorService.delete(administradorOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Administrador deletado com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAdministrador(@PathVariable(value = "id") String id, @RequestBody @Valid AdministradorDto administradorDto) {
        Optional<Administrador> administradorOptional = administradorService.findById(id);
        if (!administradorOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Administrador não encontrado!");
        }

        var administrador = administradorOptional.get();
        BeanUtils.copyProperties(administradorDto, administrador);
        return ResponseEntity.status(HttpStatus.OK).body(administradorService.save(administrador));
    }
}