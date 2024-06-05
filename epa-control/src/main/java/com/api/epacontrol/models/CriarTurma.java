package com.api.epacontrol.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "TB_CLASS_CREATED")
public class CriarTurma implements Serializable {

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

    @Embedded
    private LocalizacaoTurma localizacao;

    // Construtor vazio necessário para o JPA
    public CriarTurma() {}

    // Construtor com parâmetros
    public CriarTurma(UUID id, String nomeTurma, byte[] foto, String nomeDisciplina, String nivel, LocalDateTime hora, LocalDateTime data, LocalizacaoTurma localizacao) {
        this.id = id;
        this.nomeTurma = nomeTurma;
        this.foto = foto;
        this.nomeDisciplina = nomeDisciplina;
        this.nivel = nivel;
        this.hora = hora;
        this.data = data;
        this.localizacao = localizacao;
    }

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

    public LocalizacaoTurma getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(LocalizacaoTurma localizacao) {
        this.localizacao = localizacao;
    }
}
