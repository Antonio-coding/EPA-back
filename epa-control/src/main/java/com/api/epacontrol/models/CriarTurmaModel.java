package com.api.epacontrol.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_CLASS_CREATED")
public class CriarTurmaModel implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(name = "NOME_TURMA", nullable = false, length = 100)
  private String nomeTurma;

  @Lob
  @Column(name = "FOTO")
  private byte[] foto;

  @Column(name = "NOME_DISCIPLINA", nullable = false, length = 100)
  private String nomeDisciplina;

  @Column(name = "NIVEL", nullable = false, length = 50)
  private String nivel;

  @Column(name = "HORA", nullable = false)
  private LocalDateTime hora;

  @Column(name = "DATA", nullable = false)
  private LocalDateTime data;

  @ManyToOne
  @JoinColumn(name = "localizacao_id", nullable = false)
  private LocalizacaoTurmaModel localizacao;

  // Getters e Setters
  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getNomeTurma() {
    return nomeTurma;
  }

  public void setNomeTurma(String nomeTurma) {
    this.nomeTurma = nomeTurma;
  }

  public byte[] getFoto() {
    return foto;
  }

  public void setFoto(byte[] foto) {
    this.foto = foto;
  }

  public String getNomeDisciplina() {
    return nomeDisciplina;
  }

  public void setNomeDisciplina(String nomeDisciplina) {
    this.nomeDisciplina = nomeDisciplina;
  }

  public String getNivel() {
    return nivel;
  }

  public void setNivel(String nivel) {
    this.nivel = nivel;
  }

  public LocalDateTime getHora() {
    return hora;
  }

  public void setHora(LocalDateTime hora) {
    this.hora = hora;
  }

  public LocalDateTime getData() {
    return data;
  }

  public void setData(LocalDateTime data) {
    this.data = data;
  }

  public LocalizacaoTurmaModel getLocalizacao() {
    return localizacao;
  }

  public void setLocalizacao(LocalizacaoTurmaModel localizacao) {
    this.localizacao = localizacao;
  }
}
