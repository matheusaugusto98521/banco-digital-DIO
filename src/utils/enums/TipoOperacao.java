package utils.enums;

public enum TipoOperacao {
    SAQUE("saque"),
    DEPOSITO("depósito"),
    TRANSFERENCIA("transferência");

    private String tipoOperacao;
    TipoOperacao(String tipoOperacao){
        this.tipoOperacao = tipoOperacao;
    }
}
