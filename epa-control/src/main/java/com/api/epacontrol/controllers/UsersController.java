package com.api.epacontrol.controllers;

import com.api.epacontrol.dtos.UsersDto;
import com.api.epacontrol.models.UsersModel;
import com.api.epacontrol.services.UsersService;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.regex.Pattern;
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
    // Check for duplicate email using database constraint
    if (usersService.existsByEmail(usersDto.getEmail())) {
      return ResponseEntity
        .status(HttpStatus.CONFLICT)
        .body("Email already exists");
    }

    // Validate IP address
    String ipAddress = usersDto.getIpAddress();
    if (!isValidIpAddress(ipAddress)) {
      return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body("Invalid IP address");
    }

    // Enforce password strength
    // ... (Assume you have password encoding logic here)

    var usersModel = new UsersModel();
    BeanUtils.copyProperties(usersDto, usersModel);
    usersModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));

    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body(usersService.save(usersModel));
  }

  private boolean isValidIpAddress(String ipAddress) {
    String regex =
      "^(?:25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)\\.(?:25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)\\.(?:25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)\\.(?:25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)$";
    Pattern pattern = Pattern.compile(regex);
    return pattern.matcher(ipAddress).matches();
  }
}
