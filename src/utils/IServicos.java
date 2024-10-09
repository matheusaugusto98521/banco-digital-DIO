package utils;

import java.util.UUID;

public interface IServicos {

    public void deposito(Object conta, double valor, UUID idConta, String agencia);
    public void saque(Object conta, double valor, UUID idConta);
    public void transferencia(Object conta, Object contaEntrada, double valor, UUID idContaSaida, UUID idContaEntrada);
}
