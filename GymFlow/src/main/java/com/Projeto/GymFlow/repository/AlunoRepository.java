package com.Projeto.GymFlow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Projeto.GymFlow.models.Aluno;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByCpf(String cpf);
}
