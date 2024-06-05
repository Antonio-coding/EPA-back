package com.api.epacontrol.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TAB_USERS")
public class UsersModel implements Serializable {

  // Observação para Thiago é necessário fazer os métodos
  //   complementares que você não tem ainda como os métodos de localização para que eles criem uma
  // tabela específica OA tabela específica própria para agenda da

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(name = "NOME", nullable = false, length = 100)
  private String nome;

  @Column(name = "EMAIL", nullable = false, unique = true, length = 255)
  private String email;

  @Column(name = "SENHA", nullable = false)
  private String senha;

  @Column(nullable = false)
  private LocalDateTime registrationDate;

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  } 

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public LocalDateTime getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(LocalDateTime registrationDate) {
    this.registrationDate = registrationDate;
  }
}
