package com.Projeto.GymFlow.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Presenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "intencao_id", nullable = false)
    private Aluno aluno;
    // relação com aluno (uma presença está associada a um aluno)
    //oq signfica as assinaturas acima?
    //OneToOne significa que cada presença está associada a um único aluno
    //JoinColumn especifica a coluna na tabela de presença que referencia a tabela de aluno
    //nullable = false indica que essa coluna não pode ser nula, ou seja, toda presença deve estar associada a um aluno


    private String status; // status da presença (confirmada, cancelada, etc.)
    private LocalDateTime dataHora; // data e hora da presença


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
    public void setStatus(String status) {
        this.status = status;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }


}
