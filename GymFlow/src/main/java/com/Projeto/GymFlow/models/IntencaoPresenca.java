package com.Projeto.GymFlow.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class IntencaoPresenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id da intenção

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno; // relação com aluno

    private LocalDateTime dataHora; // quando o aluno pretende ir

    public IntencaoPresenca() {}

    public IntencaoPresenca(Aluno aluno, LocalDateTime dataHora) {
        this.aluno = aluno;
        this.dataHora = dataHora;
    }

    public Long getId() {
        return id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}
