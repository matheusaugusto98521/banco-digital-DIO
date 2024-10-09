import utils.ContaCorrente;
import utils.Funcionalidades;
import utils.Poupanca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Poupanca poupanca = new Poupanca();
        ContaCorrente contaCorrente = new ContaCorrente(); //nova instancia de poupança
        Funcionalidades servicos = new Funcionalidades(); //nova instancia de conta corrente

        //criando as contas
        //o id da conta ele gera automaticamente quando é instanciado
        poupanca.setAgencia("6738-5");
        poupanca.setVariacao("51");
        contaCorrente.setAgencia("6738-5");

        //Fazendo depósito em ambas
        servicos.deposito(poupanca,5000.0, poupanca.getIdConta(), poupanca.getAgencia());
        servicos.deposito(contaCorrente,8000.0, contaCorrente.getIdConta(), contaCorrente.getAgencia());

        //Fazendo saque em ambas
        servicos.saque(poupanca, 300.0, poupanca.getIdConta());
        servicos.saque(contaCorrente, 400.0, contaCorrente.getIdConta());

        //Consultando saldo em ambas
        servicos.consultarSaldo(poupanca, poupanca.getIdConta(), poupanca.getAgencia());
        servicos.consultarSaldo(contaCorrente, contaCorrente.getIdConta(), contaCorrente.getAgencia());

        //fazendo transferencia em ambas
        servicos.transferencia(poupanca, contaCorrente, 300.0, poupanca.getIdConta(), contaCorrente.getIdConta());
        servicos.transferencia(contaCorrente, poupanca, 400.0, contaCorrente.getIdConta(), poupanca.getIdConta());

        //Consultando saldo em ambas
        servicos.consultarSaldo(poupanca, poupanca.getIdConta(), poupanca.getAgencia());
        servicos.consultarSaldo(contaCorrente, contaCorrente.getIdConta(), contaCorrente.getAgencia());


    }
}