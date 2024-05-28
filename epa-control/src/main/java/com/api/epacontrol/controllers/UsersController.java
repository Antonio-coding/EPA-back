package com.api.epacontrol.controllers;

import com.api.epacontrol.dtos.UsersDto;
import com.api.epacontrol.models.UsersModel;
import com.api.epacontrol.services.UsersService;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    if (usersService.existsByEmail(usersDto.getEmail())) {
      return ResponseEntity
        .status(HttpStatus.CONFLICT)
        .body("Email already exists");
    }

    var usersModel = new UsersModel();
    BeanUtils.copyProperties(usersDto, usersModel);
    usersModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));

    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body(usersService.save(usersModel));
  }

  @GetMapping
  public ResponseEntity<Page<UsersModel>> getAllUsers(
    @PageableDefault(
      page = 0,
      size = 10,
      sort = "id",
      direction = Sort.Direction.ASC
    ) Pageable pageable
  ) {
    return ResponseEntity
      .status(HttpStatus.OK)
      .body(usersService.findAll(pageable));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getUserById(
    @PathVariable(value = "id") UUID id
  ) {
    Optional<UsersModel> userModelOptional = usersService.findById(id);

    if (!userModelOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
    return ResponseEntity.status(HttpStatus.OK).body(userModelOptional.get());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteUser(
    @PathVariable(value = "id") UUID id
  ) {
    Optional<UsersModel> userModelOptional = usersService.findById(id);

    if (!userModelOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
    usersService.delete(userModelOptional.get());
    return ResponseEntity
      .status(HttpStatus.OK)
      .body("user deleted successfully.");
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> updateUser(
    @PathVariable(value = "id") UUID id,
    @RequestBody @Valid UsersDto usersDto
  ) {
    Optional<UsersModel> userModelOptional = usersService.findById(id);

    if (!userModelOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    var userModel = new UsersModel();
    BeanUtils.copyProperties(usersDto, userModel);
    userModel.setId(userModelOptional.get().getId());
    userModel.setRegistrationDate(
      userModelOptional.get().getRegistrationDate()
    );

    return ResponseEntity
      .status(HttpStatus.OK)
      .body(usersService.save(userModel));
  }
}
