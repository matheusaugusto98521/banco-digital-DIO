package utils;

import java.util.UUID;

public class Funcionalidades implements IServicos{

    Poupanca poupanca = new Poupanca();
    ContaCorrente contaCorrente = new ContaCorrente();
    @Override
    public void deposito(Object conta, double valor, UUID idConta, String agencia) {
        if(conta instanceof Poupanca){
            if(((Poupanca) conta).getIdConta().equals(idConta)
                    && ((Poupanca) conta).getAgencia().equals(agencia)){
                ((Poupanca) conta).setSaldo(poupanca.getSaldo() + valor);
                System.out.println("R$" + valor + " Depositado com sucesso na poupança");
                System.out.println();
            }
        }else if(conta instanceof ContaCorrente){
            if(((ContaCorrente) conta).getIdConta().equals(idConta)
                    && ((ContaCorrente) conta).getAgencia().equals(agencia)){
                ((ContaCorrente) conta).setSaldo(contaCorrente.getSaldo() + valor);
                System.out.println("R$" + valor + " Depositado com sucesso na conta corrente");
                System.out.println();
            }
        }

    }

    @Override
    public void saque(Object conta, double valor, UUID idConta) {
        if(conta instanceof Poupanca){
            if(((Poupanca) conta).getIdConta().equals(idConta)){
                System.out.println("Seu saldo é de R$" + ((Poupanca) conta).getSaldo() + " na poupança");
                if(valor > ((Poupanca) conta).getSaldo()){
                    System.out.println("Saldo insuficiente para saque!!!");
                    System.out.println();
                }else{
                    ((Poupanca) conta).setSaldo(((Poupanca) conta).getSaldo() - valor);
                    System.out.println("Valor de R$" + valor + " retirado com sucesso da poupança!!!");
                    System.out.println("Saldo atualizado da poupança: R$" + ((Poupanca) conta).getSaldo());
                    System.out.println();
                }
            }
        }else if(conta instanceof ContaCorrente){
            if(((ContaCorrente) conta).getIdConta().equals(idConta)){
                System.out.println("Seu saldo é de R$" + ((ContaCorrente) conta).getSaldo() + " na conta corrente");
                if(valor > ((ContaCorrente) conta).getSaldo()){
                    System.out.println("Saldo insuficiente para saque na conta corrente!!!");
                }else{
                    ((ContaCorrente) conta).setSaldo(((ContaCorrente) conta).getSaldo() - valor);
                    System.out.println("Valor de R$" + valor + " retirado com sucesso da conta corrente!!!");
                    System.out.println("Saldo atualizado da conta corrente: R$" + ((ContaCorrente) conta).getSaldo());
                    System.out.println();
                }
            }
        }

    }

    @Override
    public void transferencia(Object contaSaida, Object contaEntrada, double valor, UUID idContaSaida, UUID idContaEntrada) {
        if(contaSaida instanceof Poupanca){
            if(((Poupanca) contaSaida).getIdConta().equals(idContaSaida)){
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                System.out.println(">>> CONFERIR DADOS DA CONTA POUPANÇA <<<");
                System.out.println(">>> ID da conta: " + ((Poupanca) contaSaida).getIdConta());
                System.out.println(">>> Agência: " + ((Poupanca) contaSaida).getAgencia());
                System.out.println(">>> Variação: "+ ((Poupanca) contaSaida).getVariacao());
                System.out.println(">>> Saldo disponível para transferência R$" + ((Poupanca) contaSaida).getSaldo());
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

                if(contaEntrada instanceof ContaCorrente){
                    if(((ContaCorrente) contaEntrada).getIdConta().equals(idContaEntrada)){
                        ((Poupanca) contaSaida).setSaldo(((Poupanca) contaSaida).getSaldo() - valor);
                        ((ContaCorrente) contaEntrada).setSaldo(((ContaCorrente) contaEntrada).getSaldo() + valor);
                    }else{
                        System.out.println("Conta Corrente não encontrada para o ID: " + idContaEntrada);
                    }
                }
                System.out.println(" >>> Transferência realizada com sucesso!");
                System.out.println();
            }
        } else if(contaSaida instanceof ContaCorrente){
            if(((ContaCorrente) contaSaida).getIdConta().equals(idContaSaida)){
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                System.out.println(" >>> CONFERIR DADOS DA CONTA CORRENTE <<< ");
                System.out.println(">>> ID da conta: " + ((ContaCorrente) contaSaida).getIdConta());
                System.out.println(">>> Agência: " + ((ContaCorrente) contaSaida).getAgencia());
                System.out.println(">>> Saldo disponível para transferência R$" + ((ContaCorrente) contaSaida).getSaldo());
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

                if(contaEntrada instanceof Poupanca){
                    if(((Poupanca) contaEntrada).getIdConta().equals(idContaEntrada)){
                        ((ContaCorrente) contaSaida).setSaldo(((ContaCorrente) contaSaida).getSaldo() - valor);
                        ((Poupanca) contaEntrada).setSaldo(((Poupanca) contaEntrada).getSaldo() + valor);
                    }else{
                        System.out.println("Poupança não encontrada para o ID: " + idContaEntrada);
                    }
                }
                System.out.println(" >>> Transferência realizada com sucesso!");
                System.out.println();
            }else{
                System.out.println("Conta não encontrada para o ID: " + idContaSaida);
            }
        }
    }

    public void consultarSaldo(Object conta, UUID idConta, String agencia){
        if(conta instanceof Poupanca){
            if (((Poupanca) conta).getIdConta().equals(idConta)
            && ((Poupanca) conta).getAgencia().equals(agencia)){
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                System.out.println(">>> SALDO DA CONTA POUPANÇA R$: " + ((Poupanca) conta).getSaldo());
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            }
        }else if(conta instanceof ContaCorrente){
            if(((ContaCorrente) conta).getIdConta().equals(idConta)
            && ((ContaCorrente) conta).getAgencia().equals(agencia)){
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                System.out.println(">>> SALDO DA CONTA CORRENTE R$: " + ((ContaCorrente) conta).getSaldo());
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            }
        }else{
            System.out.println("Conta não encontrada para o ID: " + idConta);
        }
    }
}
