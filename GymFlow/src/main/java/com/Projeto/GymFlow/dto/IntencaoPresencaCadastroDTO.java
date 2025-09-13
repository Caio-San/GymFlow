package com.Projeto.GymFlow.dto;
import java.time.LocalDateTime;

//o o pacote dto existe para fazer a transferencia de dados entre as camadas
//e evitar expor as entidades diretamente
//essa classe é usada para receber os dados de cadastro de intencao de presenca
//ela nao tem id pois o id sera gerado automaticamente pelo banco de dados
//a classe resposta tem o id pois ele ja existe no banco de dados
//ela serve para transferir os dados da camada de servico para a camada de controle
//e tambem para transferir os dados da camada de controle para a camada de apresentacao
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

public class IntencaoPresencaCadastroDTO {
    
    @NotBlank(message = "O CPF nao pode estar em branco")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 digitos numericos")
    private String cpf;

    @NotNull(message = "A data e hora nao pode ser nula")
    //data deve ser apenas no presente em diante:
    @PastOrPresent(message = "A data e hora nao pode ser no futuro")
    private LocalDateTime dataHora;

    // getters e setters
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}

