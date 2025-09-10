package com.Projeto.GymFlow.repository;

import com.Projeto.GymFlow.models.Presenca;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PresencaRepository extends JpaRepository<Presenca, Long> {
    long countByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);


    
    // Conta intenções de presença nos últimos 30 minutos
    @Query("SELECT COUNT(p) FROM Presenca p WHERE p.status = 'INTENCAO' AND p.dataHora BETWEEN :inicio AND :fim")
    long countIntencoesUltimos30Minutos(@Param("inicio") LocalDateTime inicio, @Param("fim") LocalDateTime fim);

}
