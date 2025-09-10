package com.Projeto.GymFlow.dto;

import java.time.LocalDateTime;



public class IntencaoPresencaRespostaDTO {
    private Long id;
    private String alunoCpf;
    private String alunoNome;
    private LocalDateTime dataHora;
    
    public IntencaoPresencaRespostaDTO() {}

    public IntencaoPresencaRespostaDTO(Long id, String alunoCpf, String alunoNome, LocalDateTime dataHora) {
        this.id = id;
        this.alunoCpf = alunoCpf;
        this.alunoNome = alunoNome;
        this.dataHora = dataHora;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAlunoCpf() {
        return alunoCpf;
    }
    public void setAlunoCpf(String alunoCpf) {
        this.alunoCpf = alunoCpf;
    }
    public String getAlunoNome() {
        return alunoNome;
    }
    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }


}

