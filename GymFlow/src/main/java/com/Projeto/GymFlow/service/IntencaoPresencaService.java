package com.Projeto.GymFlow.service;

import com.Projeto.GymFlow.dto.IntencaoPresencaCadastroDTO;
import com.Projeto.GymFlow.dto.IntencaoPresencaRespostaDTO;
import com.Projeto.GymFlow.models.Aluno;
import com.Projeto.GymFlow.models.IntencaoPresenca;
import com.Projeto.GymFlow.repository.AlunoRepository;
import com.Projeto.GymFlow.repository.IntencaoPresencaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IntencaoPresencaService {

    private final IntencaoPresencaRepository intencaoPresencaRepository;
    private final AlunoRepository alunoRepository;

    public IntencaoPresencaService(IntencaoPresencaRepository intencaoPresencaRepository,
                                   AlunoRepository alunoRepository) {
        this.intencaoPresencaRepository = intencaoPresencaRepository;
        this.alunoRepository = alunoRepository;
    }

    // cadastrar intenção
    public IntencaoPresencaRespostaDTO cadastrar(IntencaoPresencaCadastroDTO dto) {
    Aluno aluno = alunoRepository.findByCpf(dto.getCpf())
            .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

    IntencaoPresenca intencao = new IntencaoPresenca(aluno, dto.getDataHora());
    IntencaoPresenca salvo = intencaoPresencaRepository.save(intencao);

    return new IntencaoPresencaRespostaDTO(
            salvo.getId(),
            aluno.getCpf(),  // aqui você pode usar CPF no lugar do ID
            aluno.getNome(),
            salvo.getDataHora()
    );
}


    // listar todas intenções
    public List<IntencaoPresencaRespostaDTO> listarTodos() {
        return intencaoPresencaRepository.findAll().stream()
                .map(i -> new IntencaoPresencaRespostaDTO(
                        i.getId(),
                        i.getAluno().getCpf(),
                        i.getAluno().getNome(),
                        i.getDataHora()))
                .collect(Collectors.toList());
    }
}
