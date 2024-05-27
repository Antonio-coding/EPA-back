package com.api.epacontrol.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UsersDto {

  @NotBlank(message = "O nome do usuário não pode ser vazio.")
  @Size(
    min = 3,
    max = 100,
    message = "O nome do usuário deve ter entre 3 e 100 caracteres."
  )
  private String nome;

  @NotBlank(message = "O email do usuário não pode ser vazio.")
  @Email(message = "O email do usuário deve ser um email válido.")
  private String email;

  @NotBlank(message = "A senha do usuário não pode ser vazia.")
  @Size(
    min = 8,
    max = 64,
    message = "A senha do usuário deve ter entre 8 e 64 caracteres."
  )
  @Pattern(
    regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$#@]).*$",
    message = "A senha deve conter pelo menos uma letra minúscula, uma maiúscula, um número e um caractere especial."
  )
  private String senha;

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
}
