package com.api.epacontrol.dtos;

import jakarta.validation.constraints.NotBlank;

public class LocalizacaoTurmaDto {

  @NotBlank(message = "O endereço não pode ser vazio.")
  private String endereco;

  @NotBlank(message = "A cidade não pode ser vazia.")
  private String cidade;

  @NotBlank(message = "O estado não pode ser vazio.")
  private String estado;

  @NotBlank(message = "O CEP não pode ser vazio.")
  private String cep;

  // Getters e Setters

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
