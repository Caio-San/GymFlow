package com.Projeto.GymFlow.controller;



import com.Projeto.GymFlow.service.AdministradorService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Projeto.GymFlow.dto.AdministradorCadastroDTO;
import com.Projeto.GymFlow.dto.AdministradorRespostaDTO;


@RestController
@RequestMapping("/administradores")
public class AdministradorController {
    private final AdministradorService service;

    public AdministradorController(AdministradorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AdministradorRespostaDTO> cadastrarAdministrador(@RequestBody @Valid AdministradorCadastroDTO administradorDto) {
        return ResponseEntity.ok(service.cadastrarAdministrador(administradorDto));
    }


    @GetMapping
    public java.util.List<AdministradorRespostaDTO> listar() {
        return service.listarAdministradores();
    }
}
