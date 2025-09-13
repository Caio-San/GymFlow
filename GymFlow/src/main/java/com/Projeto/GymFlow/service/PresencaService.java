package com.Projeto.GymFlow.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Projeto.GymFlow.repository.AlunoRepository;
import com.Projeto.GymFlow.repository.PresencaRepository;
import com.Projeto.GymFlow.models.Presenca;
import com.Projeto.GymFlow.dto.PresencaCadastroDTO;
import com.Projeto.GymFlow.dto.PresencaRespostaDTO;
import com.Projeto.GymFlow.models.Aluno;
import com.Projeto.GymFlow.dto.LotacaoRespostaDTO;


@Service
public class PresencaService {
    private final PresencaRepository presencaRepository;
    private final AlunoRepository alunoRepository;

    public PresencaService(PresencaRepository presencaRepository, AlunoRepository alunoRepository) {
        this.presencaRepository = presencaRepository;
        this.alunoRepository = alunoRepository;
    }

    // cadastrar presença a partir do CPF
    public PresencaRespostaDTO cadastrarPresenca(PresencaCadastroDTO dto) {
        // busca o aluno pelo CPF
        Aluno aluno = alunoRepository.findByCpf(dto.getCpf())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        // cria a presença
        Presenca presenca = new Presenca();
        presenca.setAluno(aluno);
        presenca.setStatus(dto.getStatus() != null ? dto.getStatus() : "PRESENTE");
        //a data deve sempre ser a atual
        presenca.setDataHora(LocalDateTime.now());

        Presenca presencaSalva = presencaRepository.save(presenca);

        // monta resposta
        return new PresencaRespostaDTO(
                presencaSalva.getId(),
                aluno,
                presencaSalva.getStatus(),
                presencaSalva.getDataHora()
        );
    }

    // listar todas as presenças
    public List<PresencaRespostaDTO> listarTodasPresencas() {
        return presencaRepository.findAll().stream()
                .map(p -> new PresencaRespostaDTO(
                        p.getId(),
                        p.getAluno(),
                        p.getStatus(),
                        p.getDataHora()))
                .toList();
    }


    // obter lotação em tempo real (últimos 30 minutos)
    //essa função conta quantas presenças foram registradas nos últimos 30 minutos
    public LotacaoRespostaDTO obterLotacaoTempoRealDetalhada() {
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime limite = agora.minusMinutes(30);

        // contagem de presenças reais
        long lotacaoReal = presencaRepository.countByDataHoraBetween(limite, agora);

        // contagem de intenções de presença (status = "INTENCAO")
        long lotacaoIntencao = presencaRepository.countIntencoesUltimos30Minutos(limite, agora);

        // capacidade máxima fixa
        long capacidadeMaxima = 20;

        // cálculo do percentual
        double percentual = capacidadeMaxima > 0 
                ? (lotacaoReal * 100.0 / capacidadeMaxima) 
                : 0;

        LotacaoRespostaDTO dto = new LotacaoRespostaDTO();
        dto.setLotacaoReal(lotacaoReal);
        dto.setLotacaoIntencao(lotacaoIntencao);
        dto.setCapacidadeMaxima(capacidadeMaxima);
        dto.setPercentualOcupacao(percentual);

        return dto;
    }
}
