package com.Projeto.GymFlow.controller;


import com.Projeto.GymFlow.dto.AlunoCadastroDTO;
import com.Projeto.GymFlow.dto.AlunoRespostaDTO;
import com.Projeto.GymFlow.service.AlunoService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @PostMapping
    public AlunoRespostaDTO cadastrar(@RequestBody AlunoCadastroDTO dto) {
        return service.cadastrarAluno(dto);
    }

    @GetMapping
    public List<AlunoRespostaDTO> listar() {
        return service.listarAlunos();
    }
}
