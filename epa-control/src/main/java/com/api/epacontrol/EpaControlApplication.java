package com.api.epacontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class EpaControlApplication {

  public static void main(String[] args) {
    SpringApplication.run(EpaControlApplication.class, args);
  }

  @GetMapping("/")
  public String index() {
    return "Ola Moundo thiago";
  }
}
