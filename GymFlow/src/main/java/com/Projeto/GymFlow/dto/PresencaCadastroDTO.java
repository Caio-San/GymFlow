package com.Projeto.GymFlow.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;



public class PresencaCadastroDTO {
    @NotBlank(message = "O CPF nao pode estar em branco")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 digitos numericos")
    private String cpf; // apenas o CPF do 
    
    @NotBlank(message = "O status nao pode estar em branco")
    private String status;


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

}

