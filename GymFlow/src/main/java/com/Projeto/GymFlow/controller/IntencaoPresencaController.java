package com.Projeto.GymFlow.controller;

import com.Projeto.GymFlow.dto.IntencaoPresencaCadastroDTO;
import com.Projeto.GymFlow.dto.IntencaoPresencaRespostaDTO;
import com.Projeto.GymFlow.service.IntencaoPresencaService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/intencoes")
public class IntencaoPresencaController {

    private final IntencaoPresencaService service;

    public IntencaoPresencaController(IntencaoPresencaService service) {
        this.service = service;
    }
    //recebo oas requisiç~eos HTTPS faço o request para receber um corpo para requisição e converter
    //essa requisição vai ser tratada com o service adequado(regra de negocio) e depois retorna um DTO de resposta
    //DTO de resposta é um objeto que vai ser convertido em JSON e enviado para o cliente

    //oque eu escrevi acima esta certo?
    //
    @PostMapping
    public ResponseEntity<IntencaoPresencaRespostaDTO> registrarIntencao(@RequestBody @Valid IntencaoPresencaCadastroDTO intencaoDto) {
        return ResponseEntity.ok(service.cadastrar(intencaoDto));
    }

    @GetMapping
    public List<IntencaoPresencaRespostaDTO> listarTodos() {
        return service.listarTodos();
    }
}
