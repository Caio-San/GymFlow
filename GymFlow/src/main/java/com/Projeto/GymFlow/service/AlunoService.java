package com.Projeto.GymFlow.service;

import com.Projeto.GymFlow.dto.AlunoCadastroDTO;
import com.Projeto.GymFlow.dto.AlunoRespostaDTO;
import com.Projeto.GymFlow.models.Aluno;
import com.Projeto.GymFlow.repository.AlunoRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    // Cadastrar aluno
    public AlunoRespostaDTO cadastrarAluno(AlunoCadastroDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setCpf(dto.getCpf());
        aluno.setNome(dto.getNome());

        Aluno salvo = repository.save(aluno);

        return new AlunoRespostaDTO(salvo.getCpf(), salvo.getNome());
    }

    // Listar alunos
    public List<AlunoRespostaDTO> listarAlunos() {
        return repository.findAll()
                .stream()
                .map(a -> new AlunoRespostaDTO(a.getCpf(), a.getNome()))
                .collect(Collectors.toList());
    }
}
