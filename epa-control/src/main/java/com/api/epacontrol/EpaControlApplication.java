package com.api.epacontrol;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EpaControlApplication {

  public static void main(String[] args) {
    // Load environment variables from .env file
    Dotenv dotenv = Dotenv.configure().load();
    dotenv
      .entries()
      .forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

    // Run the Spring Boot application
    SpringApplication.run(EpaControlApplication.class, args);
  }

  @GetMapping("/")
  public String index() {
    return "Ola Mundo Thiago";
  }
}
