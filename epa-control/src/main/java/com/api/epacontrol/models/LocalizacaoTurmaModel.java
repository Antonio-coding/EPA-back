package com.api.epacontrol.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_LOCALIZACAO_TURMA")
public class LocalizacaoTurmaModel implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(name = "ENDERECO", nullable = false, length = 255)
  private String endereco;

  @Column(name = "CIDADE", nullable = false, length = 100)
  private String cidade;

  @Column(name = "ESTADO", nullable = false, length = 100)
  private String estado;

  @Column(name = "CEP", nullable = false, length = 20)
  private String cep;

  // Getters e Setters
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }
}
