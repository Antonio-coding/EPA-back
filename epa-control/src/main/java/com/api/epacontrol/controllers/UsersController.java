package com.api.epacontrol.controllers;

import com.api.epacontrol.dtos.UsersDto;
import com.api.epacontrol.models.UsersModel;
import com.api.epacontrol.services.UsersService;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/users")
public class UsersController {

  final UsersService usersService;

  public UsersController(UsersService usersService) {
    this.usersService = usersService;
  }

  @PostMapping
  public ResponseEntity<Object> saveUsers(
    @RequestBody @Valid UsersDto usersDto
  ) {
    var usersModel = new UsersModel();
    BeanUtils.copyProperties(usersDto, usersModel);
    usersModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));

    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body(usersService.save(usersModel));
  }
}
