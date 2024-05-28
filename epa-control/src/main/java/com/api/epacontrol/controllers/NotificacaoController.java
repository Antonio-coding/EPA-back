package com.api.epacontrol.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.epacontrol.dtos.NotificacaoDto;
import com.api.epacontrol.models.Notificacao;
import com.api.epacontrol.models.UsersModel;
import com.api.epacontrol.services.NotificacaoService;
import com.api.epacontrol.services.UsersService;

import jakarta.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/notificacao")
public class NotificacaoController {

    @Autowired
    NotificacaoService notificacaoService;

    @Autowired
    UsersService usersService;

    @PostMapping
    public ResponseEntity<Object> saveNotificacao(@RequestBody @Valid NotificacaoDto notificacaoDto) {
        if (notificacaoService.existsById(notificacaoDto.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Notificação já existe!");
        }

        Optional<UsersModel> recipientOptional = usersService.findById(notificacaoDto.getRecipientId());
        if (!recipientOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }

        UsersModel recipient = recipientOptional.get();
        var notificacao = new Notificacao();
        BeanUtils.copyProperties(notificacaoDto, notificacao);
        notificacao.setRecipient(recipient);

        return ResponseEntity.status(HttpStatus.CREATED).body(notificacaoService.save(notificacao));
    }

}




