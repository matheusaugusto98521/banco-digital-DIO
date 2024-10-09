package utils.models;

import utils.enums.TipoOperacao;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transacao {
    private UUID idTransacao;
    private String descricao;
    private double valor;
    private TipoOperacao tipoOperacao;
    private double saldoAfter;
    private LocalDateTime data_hora;

    public Transacao(String descricao, double valor, TipoOperacao tipoOperacao, double saldoAfter) {
        this.idTransacao = UUID.randomUUID();
        this.descricao = descricao;
        this.valor = valor;
        this.tipoOperacao = tipoOperacao;
        this.saldoAfter = saldoAfter;
        this.data_hora = LocalDateTime.now();
    }

    public UUID getIdTransacao() {
        return idTransacao;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(TipoOperacao tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public double getSaldoAfter() {
        return saldoAfter;
    }

    public void setSaldoAfter(double saldoAfter) {
        this.saldoAfter = saldoAfter;
    }
}
