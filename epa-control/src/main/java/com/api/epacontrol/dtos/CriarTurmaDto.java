package com.api.epacontrol.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public class CriarTurmaDto {

    @NotBlank(message = "O nome da turma não pode ser vazio.")
    @Size(min = 3, max = 100, message = "O nome da turma deve ter entre 3 e 100 caracteres.")
    private String nomeTurma;

    private byte[] foto;

    @NotBlank(message = "O nome da disciplina não pode ser vazio.")
    @Size(min = 3, max = 100, message = "O nome da disciplina deve ter entre 3 e 100 caracteres.")
    private String nomeDisciplina;

    @NotBlank(message = "O nível da turma não pode ser vazio.")
    @Size(min = 1, max = 50, message = "O nível da turma deve ter entre 1 e 50 caracteres.")
    private String nivel;

    @NotNull(message = "A hora não pode ser nula.")
    private LocalDateTime hora;

    @NotNull(message = "A data não pode ser nula.")
    private LocalDateTime data;

    @NotNull(message = "A localização não pode ser nula.")
    private LocalizacaoTurmaDto localizacao;

    // Getters e Setters

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

    public LocalizacaoTurmaDto getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(LocalizacaoTurmaDto localizacao) {
        this.localizacao = localizacao;
    }
}
