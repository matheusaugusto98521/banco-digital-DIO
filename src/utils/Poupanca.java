package utils;

import java.util.UUID;

public class Poupanca{

    private UUID idConta;
    private String agencia;
    private String variacao;
    private double saldo;

    public Poupanca() {
        this.idConta = UUID.randomUUID();
    }

    public UUID getIdConta() {
        return idConta;
    }

    public String getVariacao() {
        return variacao;
    }

    public void setVariacao(String variacao) {
        this.variacao = variacao;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
}
