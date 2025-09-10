package com.Projeto.GymFlow.dto;

/**
 * DTO para retornar informações de lotação da academia.
 * Inclui lotação real, intenção de presença, capacidade máxima e percentual de ocupação.
 */
public class LotacaoRespostaDTO {

    private long lotacaoReal;       // número de pessoas presentes
    private long lotacaoIntencao;   // número de pessoas que planejam ir
    private long capacidadeMaxima;  // capacidade máxima do horário
    private double percentualOcupacao; // lotacaoReal / capacidadeMaxima * 100

    // Construtor vazio
    public LotacaoRespostaDTO() {}

    // Construtor completo
    public LotacaoRespostaDTO(long lotacaoReal, long lotacaoIntencao, long capacidadeMaxima) {
        this.lotacaoReal = lotacaoReal;
        this.lotacaoIntencao = lotacaoIntencao;
        this.capacidadeMaxima = capacidadeMaxima;
        this.percentualOcupacao = capacidadeMaxima > 0
                ? (lotacaoReal * 100.0 / capacidadeMaxima)
                : 0;
    }

    // Getters e Setters
    public long getLotacaoReal() {
        return lotacaoReal;
    }

    public void setLotacaoReal(long lotacaoReal) {
        this.lotacaoReal = lotacaoReal;
    }

    public long getLotacaoIntencao() {
        return lotacaoIntencao;
    }

    public void setLotacaoIntencao(long lotacaoIntencao) {
        this.lotacaoIntencao = lotacaoIntencao;
    }

    public long getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(long capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public double getPercentualOcupacao() {
        return percentualOcupacao;
    }

    public void setPercentualOcupacao(double percentualOcupacao) {
        this.percentualOcupacao = percentualOcupacao;
    }

    @Override
    public String toString() {
        return "LotacaoDTO{" +
                "lotacaoReal=" + lotacaoReal +
                ", lotacaoIntencao=" + lotacaoIntencao +
                ", capacidadeMaxima=" + capacidadeMaxima +
                ", percentualOcupacao=" + percentualOcupacao +
                '}';
    }
}
