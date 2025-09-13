package com.Projeto.GymFlow.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Presenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;


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
