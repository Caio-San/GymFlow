package com.Projeto.GymFlow.controller;

import com.Projeto.GymFlow.dto.PresencaCadastroDTO;
import com.Projeto.GymFlow.dto.PresencaRespostaDTO;
import com.Projeto.GymFlow.service.PresencaService;

import jakarta.validation.Valid;

import com.Projeto.GymFlow.dto.LotacaoRespostaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/presencas")
public class PresencaController {

    private final PresencaService presencaService;

    public PresencaController(PresencaService presencaService) {
        this.presencaService = presencaService;
    }

    // cadastrar presença
    @PostMapping
    public ResponseEntity<PresencaRespostaDTO> registrarPresenca(@RequestBody @Valid PresencaCadastroDTO presencaDto) {
        return ResponseEntity.ok(presencaService.cadastrarPresenca(presencaDto));
    }

    // listar todas presenças
    @GetMapping
    public List<PresencaRespostaDTO> listar() {
        return presencaService.listarTodasPresencas();
    }

    // obter lotação em tempo real (últimos 30 minutos)
    @GetMapping("/lotacao-tempo-real")
    public ResponseEntity<LotacaoRespostaDTO> getLotacaoTempoReal() {
        LotacaoRespostaDTO lotacao = presencaService.obterLotacaoTempoRealDetalhada();
        return ResponseEntity.ok(lotacao);
    }

    //o teste http para testar é: 
    //http://localhost:8080/presencas/lotacao-tempo-real
}
