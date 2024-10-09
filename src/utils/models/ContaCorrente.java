package utils.models;

import java.util.UUID;

public class ContaCorrente{
    private UUID idConta;
    private String agencia;
    private double saldo;

    public ContaCorrente() {
        this.idConta = UUID.randomUUID();
    }

    public String getAgencia() {
        return agencia;
    }

    public UUID getIdConta() {
        return idConta;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
