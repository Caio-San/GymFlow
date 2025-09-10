package com.Projeto.GymFlow.dto;

import java.time.LocalDateTime;
import com.Projeto.GymFlow.models.Aluno;


public class PresencaRespostaDTO {
    private Long id;
    private Aluno aluno;
    private String status;
    private LocalDateTime dataHora;


    public PresencaRespostaDTO() {}

    public PresencaRespostaDTO(Long id, Aluno aluno, String status, LocalDateTime dataHora) {
        this.id = id;
        this.aluno = aluno;
        this.status = status;
        this.dataHora = dataHora;
    }

    public Long getId() {
        return id;
    }
    public Aluno getAluno() {
        return aluno;
    }
    public String getStatus() {
        return status;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    

}
