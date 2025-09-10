package com.Projeto.GymFlow.dto;

import java.time.LocalDateTime;


public class PresencaCadastroDTO {
    private String cpf; // apenas o CPF do aluno
    private String status;
    private LocalDateTime dataHora;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}

