package com.Projeto.GymFlow.service;

import org.springframework.stereotype.Service;
import com.Projeto.GymFlow.repository.AdministradorRepository;
import com.Projeto.GymFlow.models.Administrador;
import com.Projeto.GymFlow.dto.AdministradorCadastroDTO;
import com.Projeto.GymFlow.dto.AdministradorRespostaDTO;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AdministradorService {
    private final AdministradorRepository repository;

    public AdministradorService(AdministradorRepository repository) {
        this.repository = repository;
    }

    // Cadastrar administrador
    public AdministradorRespostaDTO cadastrarAdministrador(AdministradorCadastroDTO dto) {
        Administrador administrador = new Administrador();
        administrador.setCpf(dto.getCpf());
        administrador.setNome(dto.getNome());

        Administrador salvo = repository.save(administrador);

        return new AdministradorRespostaDTO(salvo.getCpf(), salvo.getNome());
    }

    // Listar administradores
    public List<AdministradorRespostaDTO> listarAdministradores() {
        return repository.findAll()
                .stream()
                .map(a -> new AdministradorRespostaDTO(a.getCpf(), a.getNome()))
                .collect(Collectors.toList());
    }
}
