package com.Projeto.GymFlow.controller;

import com.Projeto.GymFlow.dto.AlunoCadastroDTO;
import com.Projeto.GymFlow.dto.AlunoRespostaDTO;
import com.Projeto.GymFlow.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<AlunoRespostaDTO> cadastrarAluno(@RequestBody @Valid AlunoCadastroDTO alunoDto) {
        return ResponseEntity.ok(alunoService.cadastrarAluno(alunoDto));
    }

    @GetMapping
    public java.util.List<AlunoRespostaDTO> listarAlunos() {
        return alunoService.listarAlunos();
    }
    
}
