package com.Projeto.GymFlow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class AdministradorCadastroDTO {
    @NotBlank(message = "O CPF não pode estar em branco.")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter exatamente 11 dígitos numéricos.")
    private String cpf;

    @NotBlank(message = "O nome não pode estar em branco.")
    private String nome;
    
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
